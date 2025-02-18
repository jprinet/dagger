# Copyright (C) 2017 The Dagger Authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

"""This file defines constants useful across the Dagger tests."""

load("@rules_java//java:defs.bzl", "java_library", "java_test")
load(
    "@io_bazel_rules_kotlin//kotlin:kotlin.bzl",
    "kt_jvm_library",
    "kt_jvm_test",
)

# Defines a set of build variants and the list of extra javacopts to build with.
# The key will be appended to the generated test names to ensure uniqueness.
BUILD_VARIANTS = {
    "ExtendsComponent": ["-Adagger.generatedClassExtendsComponent=enabled"],
    "Shards": ["-Adagger.keysPerComponentShard=2"],
    "FastInit": ["-Adagger.fastInit=enabled"],
    "FastInit_Shards": ["-Adagger.fastInit=enabled", "-Adagger.keysPerComponentShard=2"],
}

# TODO(ronshapiro): convert this to use bazel_common
# TODO(bcorso): split into two functions for functional vs non-functional tests?
def GenJavaTests(
        name,
        srcs,
        deps = None,
        test_only_deps = None,
        plugins = None,
        javacopts = None,
        lib_javacopts = None,
        test_javacopts = None,
        functional = True):
    has_kotlin_sources = any([
        src
        for src in srcs
        if src.endswith(".kt") and not src.endswith("Test.kt")
    ])
    _GenTests(
        kt_jvm_library if has_kotlin_sources else java_library,
        java_test,
        name,
        srcs,
        deps,
        test_only_deps,
        plugins,
        javacopts,
        lib_javacopts,
        test_javacopts,
        functional,
    )

def GenRobolectricTests(
        name,
        srcs,
        deps = None,
        test_only_deps = None,
        plugins = None,
        javacopts = None,
        lib_javacopts = None,
        test_javacopts = None,
        functional = True,
        manifest_values = None):
    deps = (deps or []) + ["//:android_local_test_exports"]
    _GenTests(
        native.android_library,
        native.android_local_test,
        name,
        srcs,
        deps,
        test_only_deps,
        plugins,
        javacopts,
        lib_javacopts,
        test_javacopts,
        functional,
        test_kwargs = {"manifest_values": manifest_values},
    )

def _GenTests(
        library_rule_type,
        test_rule_type,
        name,
        srcs,
        deps,
        test_only_deps,
        plugins,
        javacopts,
        lib_javacopts,
        test_javacopts,
        functional,
        test_kwargs = None):
    _gen_tests(
        library_rule_type,
        test_rule_type,
        name,
        srcs,
        deps,
        test_only_deps,
        plugins,
        javacopts,
        lib_javacopts,
        test_javacopts,
        functional,
        test_kwargs = test_kwargs,
    )

    if functional:
        for (variant_name, extra_javacopts) in BUILD_VARIANTS.items():
            variant_javacopts = (javacopts or []) + extra_javacopts

            _gen_tests(
                library_rule_type,
                test_rule_type,
                name,
                srcs,
                deps,
                test_only_deps,
                plugins,
                variant_javacopts,
                lib_javacopts,
                test_javacopts,
                functional,
                variant_name,
                test_kwargs = test_kwargs,
            )

def _gen_tests(
        library_rule_type,
        test_rule_type,
        name,
        srcs,
        deps,
        test_only_deps,
        plugins,
        javacopts,
        lib_javacopts,
        test_javacopts,
        functional,
        variant_name = None,
        test_kwargs = None):
    if variant_name:
        suffix = "_" + variant_name
        tags = [variant_name]

        # Add jvm_flags so that the mode can be accessed from within tests.
        jvm_flags = ["-Ddagger.mode=" + variant_name]
    else:
        suffix = ""
        tags = []
        jvm_flags = []

    test_files = []
    supporting_files = []

    for src in srcs:
        if src.endswith("Test.java"):
            test_files.append(src)
        else:
            supporting_files.append(src)

    if not test_kwargs:
        test_kwargs = {}

    if not deps:
        deps = []

    if not test_only_deps:
        test_only_deps = []

    if not plugins:
        plugins = []

    test_deps = test_only_deps + deps
    if supporting_files:
        supporting_files_name = name + suffix + "_lib"
        test_deps.append(":" + supporting_files_name)
        javacopts_kwargs = {"javacopts": ((javacopts or []) + (lib_javacopts or []))}
        if library_rule_type == kt_jvm_library:
            javacopts_kwargs = {}
        library_rule_type(
            name = supporting_files_name,
            testonly = 1,
            srcs = supporting_files,
            plugins = plugins,
            tags = tags,
            deps = deps,
            **javacopts_kwargs
        )
        if (functional and library_rule_type != kt_jvm_library):
            _hjar_test(supporting_files_name, tags)

    should_add_goldens = not functional and (test_rule_type == java_test)
    for test_file in test_files:
        test_name = test_file.replace(".java", "")
        prefix_path = "src/test/java/"
        package_name = native.package_name()
        if package_name.find("javatests/") != -1:
            prefix_path = "javatests/"
        if should_add_goldens:
            test_kwargs["resources"] = native.glob(["goldens/%s_*" % test_name])
        test_class = (package_name + "/" + test_name).rpartition(prefix_path)[2].replace("/", ".")
        test_rule_type(
            name = test_name + suffix,
            srcs = [test_file],
            javacopts = (javacopts or []) + (test_javacopts or []),
            jvm_flags = jvm_flags,
            plugins = plugins,
            tags = tags,
            test_class = test_class,
            deps = test_deps,
            **test_kwargs
        )

def _hjar_test(name, tags):
    pass
