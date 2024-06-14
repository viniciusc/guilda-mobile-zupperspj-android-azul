package config

import org.gradle.api.artifacts.dsl.DependencyHandler

object TestLibs {
    private const val JUNIT4 = "junit:junit:${Versioning.JUNIT_VERSION}"
    private const val JSON = "org.json:json:${Versioning.JSON_VERSION}"

    private object Coroutines {
        const val TEST_COROUTINE_RULE = "com.github.marcinOz:TestCoroutineRule:${Versioning.TEST_COROUTINE_RULE_VERSION}"
        const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versioning.COROUTINES_VERSION}"
    }
    private object Espresso {
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versioning.ESPRESSO_VERSION}"
        const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:${Versioning.ESPRESSO_VERSION}"
        const val ESPRESSO_ACCESSIBILITY = "androidx.test.espresso:espresso-accessibility:${Versioning.ESPRESSO_VERSION}"
        const val ESPRESSO_INTENTS = "androidx.test.espresso:espresso-intents:${Versioning.ESPRESSO_VERSION}"
    }

    private object Mock {
        const val MOCKK = "io.mockk:mockk:${Versioning.MOCKK_VERSION}"
        const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versioning.MOCKK_VERSION}"
    }

    private object AndroidX {
        const val ANDROIDX_TEST_EXT_JUNIT = "androidx.test.ext:junit-ktx:${Versioning.ANDROIDX_TEST_EXT_JUNIT_VERSION}"
        const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:${Versioning.ANDROID_TEST_VERSION}"
        const val ANDROIDX_TEST_RULES = "androidx.test:rules:${Versioning.ANDROID_TEST_VERSION}"
        const val ANDROIDX_TEST_CORE = "androidx.test:core-ktx:${Versioning.ANDROID_TEST_VERSION}"
        const val ANDROIDX_ARCH_CORE_TESTING = "androidx.arch.core:core-testing:${Versioning.ANDROIDX_ARCH_CORE_TESTING}"
        const val ANDROIDX_TEST_ORCHESTRATOR = "androidx.test:orchestrator:${Versioning.ANDROID_TEST_VERSION}"
        const val ANDROIDX_FRAGMENT_TESTING = "androidx.fragment:fragment-testing:${Versioning.ANDROIDX_FRAGMENT_VERSION}"
    }

    fun DependencyHandler.json() = testImplementation(JSON)
    fun DependencyHandler.testOrchestrator() = androidTestUtil(AndroidX.ANDROIDX_TEST_ORCHESTRATOR)
    fun DependencyHandler.junit4() = testImplementation(JUNIT4)

    fun DependencyHandler.coroutinesTest() {
        testImplementation(Coroutines.TEST_COROUTINE_RULE)
        testImplementation(Coroutines.COROUTINES_TEST)
        androidTestImplementation(Coroutines.COROUTINES_TEST)
    }

    fun DependencyHandler.espresso() {
        androidTestImplementation(Espresso.ESPRESSO_CORE)
        androidTestImplementation(Espresso.ESPRESSO_CONTRIB)
        androidTestImplementation(Espresso.ESPRESSO_ACCESSIBILITY)
        androidTestImplementation(Espresso.ESPRESSO_INTENTS)
    }

    fun DependencyHandler.mockk() {
        testImplementation(Mock.MOCKK)
        androidTestImplementation(Mock.MOCKK_ANDROID)
    }

    fun DependencyHandler.androidXTest() {
        testImplementation(AndroidX.ANDROIDX_TEST_EXT_JUNIT)
        androidTestImplementation(AndroidX.ANDROIDX_TEST_EXT_JUNIT)
        androidTestImplementation(AndroidX.ANDROIDX_TEST_RUNNER)
        androidTestImplementation(AndroidX.ANDROIDX_TEST_RULES)
        debugImplementation(AndroidX.ANDROIDX_TEST_CORE)
        debugImplementation(AndroidX.ANDROIDX_ARCH_CORE_TESTING)
        debugImplementation(AndroidX.ANDROIDX_FRAGMENT_TESTING)
    }

}
