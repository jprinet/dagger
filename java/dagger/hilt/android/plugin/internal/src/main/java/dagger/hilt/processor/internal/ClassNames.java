/*
 * Copyright (C) 2019 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.hilt.processor.internal;

import com.squareup.javapoet.ClassName;

/** Holder for commonly used class names. */
public final class ClassNames {
  public static final ClassName AGGREGATED_ELEMENT_PROXY =
      ClassName.get("dagger.hilt.android.internal.legacy", "AggregatedElementProxy");
  public static final ClassName COMPONENT_TREE_DEPS =
      ClassName.get("dagger.hilt.internal.componenttreedeps", "ComponentTreeDeps");

  public static final String AGGREGATED_ROOT_PACKAGE =
      "dagger.hilt.internal.aggregatedroot.codegen";
  public static final ClassName AGGREGATED_ROOT =
      ClassName.get("dagger.hilt.internal.aggregatedroot", "AggregatedRoot");
  public static final String PROCESSED_ROOT_SENTINEL_PACKAGE =
      "dagger.hilt.internal.processedrootsentinel.codegen";
  public static final ClassName PROCESSED_ROOT_SENTINEL =
      ClassName.get("dagger.hilt.internal.processedrootsentinel", "ProcessedRootSentinel");

  public static final ClassName CONTEXTS = ClassName.get("dagger.hilt.android.internal", "Contexts");

  public static final String AGGREGATED_EARLY_ENTRY_POINT_PACKAGE =
      "dagger.hilt.android.internal.earlyentrypoint.codegen";
  public static final ClassName AGGREGATED_EARLY_ENTRY_POINT =
      ClassName.get("dagger.hilt.android.internal.earlyentrypoint", "AggregatedEarlyEntryPoint");
  public static final ClassName EARLY_ENTRY_POINT = ClassName.get("dagger.hilt.android", "EarlyEntryPoint");

  public static final String AGGREGATED_UNINSTALL_MODULES_PACKAGE =
      "dagger.hilt.android.internal.uninstallmodules.codegen";
  public static final ClassName AGGREGATED_UNINSTALL_MODULES =
      ClassName.get("dagger.hilt.android.internal.uninstallmodules", "AggregatedUninstallModules");

  public static final ClassName ORIGINATING_ELEMENT =
      ClassName.get("dagger.hilt.codegen", "OriginatingElement");
  public static final ClassName AGGREGATED_DEPS =
      ClassName.get("dagger.hilt.processor.internal.aggregateddeps", "AggregatedDeps");
  public static final ClassName GENERATED_COMPONENT =
      ClassName.get("dagger.hilt.internal", "GeneratedComponent");
  public static final ClassName GENERATED_COMPONENT_MANAGER =
      ClassName.get("dagger.hilt.internal", "GeneratedComponentManager");
  public static final ClassName GENERATED_COMPONENT_MANAGER_HOLDER =
      ClassName.get("dagger.hilt.internal", "GeneratedComponentManagerHolder");
  public static final ClassName UNINSTALL_MODULES =
      ClassName.get("dagger.hilt.android.testing", "UninstallModules");

  public static final String DEFINE_COMPONENT_CLASSES_PACKAGE =
      "dagger.hilt.processor.internal.definecomponent.codegen";
  public static final ClassName DEFINE_COMPONENT = ClassName.get("dagger.hilt", "DefineComponent");
  public static final ClassName DEFINE_COMPONENT_BUILDER =
      ClassName.get("dagger.hilt", "DefineComponent", "Builder");
  public static final ClassName DEFINE_COMPONENT_NO_PARENT =
      ClassName.get("dagger.hilt.internal.definecomponent", "DefineComponentNoParent");
  public static final ClassName DEFINE_COMPONENT_CLASSES =
      ClassName.get("dagger.hilt.internal.definecomponent", "DefineComponentClasses");

  public static final ClassName ASSISTED_INJECT = ClassName.get("dagger.assisted", "AssistedInject");
  public static final ClassName BINDS =
      ClassName.get("dagger", "Binds");
  public static final ClassName BINDS_OPTIONAL_OF =
      ClassName.get("dagger", "BindsOptionalOf");
  public static final ClassName MAP_KEY = ClassName.get("dagger", "MapKey");
  public static final ClassName MODULE = ClassName.get("dagger", "Module");
  public static final ClassName MULTIBINDS =
      ClassName.get("dagger.multibindings", "Multibinds");
  public static final ClassName INTO_MAP = ClassName.get("dagger.multibindings", "IntoMap");
  public static final ClassName INTO_SET = ClassName.get("dagger.multibindings", "IntoSet");
  public static final ClassName STRING_KEY = ClassName.get("dagger.multibindings", "StringKey");
  public static final ClassName PROVIDES =
      ClassName.get("dagger", "Provides");
  public static final ClassName COMPONENT = ClassName.get("dagger", "Component");
  public static final ClassName COMPONENT_BUILDER = ClassName.get("dagger", "Component", "Builder");
  public static final ClassName SUBCOMPONENT = ClassName.get("dagger", "Subcomponent");
  public static final ClassName SUBCOMPONENT_BUILDER =
      ClassName.get("dagger", "Subcomponent", "Builder");
  public static final ClassName PRODUCTION_COMPONENT =
      ClassName.get("dagger.producers", "ProductionComponent");

  public static final ClassName CONTRIBUTES_ANDROID_INJECTOR =
      ClassName.get("dagger.android", "ContributesAndroidInjector");

  public static final ClassName INJECT =
      ClassName.get("javax.inject", "Inject");
  public static final ClassName QUALIFIER =
      ClassName.get("javax.inject", "Qualifier");
  public static final ClassName SCOPE =
      ClassName.get("javax.inject", "Scope");
  public static final ClassName PROVIDER = ClassName.get("javax.inject", "Provider");
  public static final ClassName DISABLE_INSTALL_IN_CHECK =
      ClassName.get("dagger.hilt.migration", "DisableInstallInCheck");
  public static final ClassName ALIAS_OF = ClassName.get("dagger.hilt.migration", "AliasOf");
  public static final ClassName ALIAS_OF_PROPAGATED_DATA =
      ClassName.get("dagger.hilt.internal.aliasof", "AliasOfPropagatedData");
  public static final String ALIAS_OF_PROPAGATED_DATA_PACKAGE =
      "dagger.hilt.processor.internal.aliasof.codegen";

  public static final ClassName GENERATES_ROOT_INPUT = ClassName.get("dagger.hilt", "GeneratesRootInput");
  public static final ClassName GENERATES_ROOT_INPUT_PROPAGATED_DATA =
      ClassName.get("dagger.hilt.internal.generatesrootinput", "GeneratesRootInputPropagatedData");

  public static final ClassName ACTIVITY_SCOPED =
      ClassName.get("dagger.hilt.android.scopes", "ActivityScoped");
  public static final ClassName FRAGMENT_SCOPED =
      ClassName.get("dagger.hilt.android.scopes", "FragmentScoped");
  public static final ClassName SERVICE_SCOPED = ClassName.get("dagger.hilt.android.scopes", "ServiceScoped");
  public static final ClassName VIEW_SCOPED = ClassName.get("dagger.hilt.android.scopes", "ViewScoped");

  public static final ClassName INSTALL_IN =
      ClassName.get("dagger.hilt", "InstallIn");
  public static final ClassName TEST_INSTALL_IN = ClassName.get("dagger.hilt.testing", "TestInstallIn");
  public static final ClassName ENTRY_POINT =
      ClassName.get("dagger.hilt", "EntryPoint");
  public static final ClassName ENTRY_POINTS = ClassName.get("dagger.hilt", "EntryPoints");
  public static final ClassName COMPONENT_ENTRY_POINT =
      ClassName.get("dagger.hilt.internal", "ComponentEntryPoint");
  public static final ClassName GENERATED_ENTRY_POINT =
      ClassName.get("dagger.hilt.internal", "GeneratedEntryPoint");
  public static final ClassName UNSAFE_CASTS = ClassName.get("dagger.hilt.internal", "UnsafeCasts");
  public static final ClassName ROOT_PROCESSOR =
      ClassName.get("dagger.hilt.processor.internal.root", "RootProcessor");

  public static final ClassName SINGLETON = ClassName.get("javax.inject", "Singleton");

  // TODO(erichang): Move these class names out when we factor out the android portion
  public static final ClassName APPLICATION = ClassName.get("android.app", "Application");
  public static final ClassName MULTI_DEX_APPLICATION =
      ClassName.get("androidx.multidex", "MultiDexApplication");
  public static final ClassName ANDROID_ENTRY_POINT =
      ClassName.get("dagger.hilt.android", "AndroidEntryPoint");
  public static final ClassName HILT_ANDROID_APP =
      ClassName.get("dagger.hilt.android", "HiltAndroidApp");
  public static final ClassName CONTEXT = ClassName.get("android.content", "Context");
  public static final ClassName APPLICATION_PROVIDER =
      ClassName.get("androidx.test.core.app", "ApplicationProvider");
  public static final ClassName COMPONENT_SUPPLIER =
      ClassName.get("dagger.hilt.android.internal.managers", "ComponentSupplier");
  public static final ClassName APPLICATION_CONTEXT_MODULE =
      ClassName.get("dagger.hilt.android.internal.modules", "ApplicationContextModule");
  public static final ClassName DEFAULT_ROOT =
      ClassName.get("dagger.hilt.android.internal.testing.root", "Default");
  public static final ClassName INTERNAL_TEST_ROOT =
      ClassName.get("dagger.hilt.android.internal.testing", "InternalTestRoot");
  public static final ClassName TEST_INJECTOR =
      ClassName.get("dagger.hilt.android.internal.testing", "TestInjector");
  public static final ClassName TEST_APPLICATION_COMPONENT_MANAGER =
      ClassName.get("dagger.hilt.android.internal.testing", "TestApplicationComponentManager");
  public static final ClassName TEST_APPLICATION_COMPONENT_MANAGER_HOLDER =
      ClassName.get("dagger.hilt.android.internal.testing", "TestApplicationComponentManagerHolder");
  public static final ClassName TEST_INSTANCE_HOLDER =
      ClassName.get("dagger.hilt.android.internal.testing", "TestInstanceHolder");
  public static final ClassName HILT_ANDROID_TEST =
      ClassName.get("dagger.hilt.android.testing", "HiltAndroidTest");
  public static final ClassName CUSTOM_TEST_APPLICATION =
      ClassName.get("dagger.hilt.android.testing", "CustomTestApplication");
  public static final ClassName ON_COMPONENT_READY_RUNNER =
      ClassName.get("dagger.hilt.android.testing", "OnComponentReadyRunner");
  public static final ClassName ON_COMPONENT_READY_RUNNER_HOLDER =
      ClassName.get("dagger.hilt.android.testing", "OnComponentReadyRunner", "OnComponentReadyRunnerHolder");
  public static final ClassName ANDROID_BIND_VALUE =
      ClassName.get("dagger.hilt.android.testing", "BindValue");
  public static final ClassName ANDROID_BIND_ELEMENTS_INTO_SET =
      ClassName.get("dagger.hilt.android.testing", "BindElementsIntoSet");
  public static final ClassName ANDROID_BIND_VALUE_INTO_MAP =
      ClassName.get("dagger.hilt.android.testing", "BindValueIntoMap");
  public static final ClassName ANDROID_BIND_VALUE_INTO_SET =
      ClassName.get("dagger.hilt.android.testing", "BindValueIntoSet");
  public static final ClassName APPLICATION_CONTEXT =
      ClassName.get("dagger.hilt.android.qualifiers", "ApplicationContext");
  public static final ClassName TEST_SINGLETON_COMPONENT =
      ClassName.get("dagger.hilt.internal", "TestSingletonComponent");
  public static final ClassName TEST_COMPONENT_DATA =
      ClassName.get("dagger.hilt.android.internal.testing", "TestComponentData");
  public static final ClassName TEST_COMPONENT_DATA_SUPPLIER =
      ClassName.get("dagger.hilt.android.internal.testing", "TestComponentDataSupplier");

  public static final ClassName CLASS = ClassName.get("java.lang", "Class");
  public static final ClassName LIST = ClassName.get("java.util", "List");
  public static final ClassName SET = ClassName.get("java.util", "Set");
  public static final ClassName MAP = ClassName.get("java.util", "Map");
  public static final ClassName HASH_MAP = ClassName.get("java.util", "HashMap");
  public static final ClassName HASH_SET = ClassName.get("java.util", "HashSet");
  public static final ClassName COLLECTIONS = ClassName.get("java.util", "Collections");
  public static final ClassName ARRAYS = ClassName.get("java.util", "Arrays");

  // Standard components
  public static final ClassName SINGLETON_COMPONENT =
      ClassName.get("dagger.hilt.components", "SingletonComponent");
  public static final ClassName ACTIVITY_COMPONENT =
      ClassName.get("dagger.hilt.android.components", "ActivityComponent");

  public static final ClassName PRECONDITIONS = ClassName.get("dagger.hilt.internal", "Preconditions");

  public static final ClassName OBJECT = ClassName.get("java.lang", "Object");

  public static final ClassName SUPPRESS_WARNINGS = ClassName.get("java.lang", "SuppressWarnings");
  public static final ClassName KOTLIN_SUPPRESS = ClassName.get("kotlin", "Suppress");

  // Kotlin-specific class names
  public static final ClassName KOTLIN_METADATA = ClassName.get("kotlin", "Metadata");

  private ClassNames() {}
}
