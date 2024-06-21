package config

import org.gradle.api.artifacts.dsl.DependencyHandler

object Libs {

    private const val ANDROID_CORE_KTX = "androidx.core:core-ktx:${Versioning.ANDROID_CORE_KTX_VERSION}"
    private const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versioning.CONSTRAINT_LAYOUT_VERSION}"
    private const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:{${Versioning.RECYCLER_VIEW_VERSION}}"
    private const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versioning.ANDROIDX_FRAGMENT_VERSION}"
    private const val MATERIAL_DESIGN = "com.google.android.material:material:${Versioning.MATERIAL_VERSION}"
    private const val ANDROIDX_APP_COMPAT = "androidx.appcompat:appcompat:${Versioning.ANDROIDX_APP_COMPAT_VERSION}"

    private object Lifecyle {
        const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versioning.LIFECYCLE_VERSION}"
        const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel:${Versioning.LIFECYCLE_VERSION}"
        const val LIFECYCLE_COMMON_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:${Versioning.LIFECYCLE_VERSION}"
    }

    private object Kotlin {
        const val KOTLIN_JAVA8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versioning.KOTLIN_VERSION}"
        const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${Versioning.KOTLIN_VERSION}"
        const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versioning.COROUTINES_VERSION}"
    }

    private object DependencyInjection {
        const val HILT = "com.google.dagger:hilt-android:${Versioning.HILT_VERSION}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versioning.HILT_VERSION}"
    }

    private object Network {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versioning.RETROFIT_VERSION}"
        const val RETROFIT_CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:${Versioning.RETROFIT_VERSION}"
        const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versioning.RETROFIT_VERSION}"
        const val MOSHI = "com.squareup.moshi:moshi:${Versioning.MOSHI_VERSION}"
        const val MOSHI_KOTLIN =  "com.squareup.moshi:moshi-kotlin:${Versioning.MOSHI_VERSION}"
        const val OKHTTP3_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versioning.OKHTTP3_LOGGING_INTERCEPTOR_VERSION}"
    }

    private object DebugTools {
        const val CHUCK_DEBUG = "com.readystatesoftware.chuck:library:${Versioning.CHUCK_VERSION}"
        const val CHUCK_RELEASE_NO_OP = "com.readystatesoftware.chuck:library-no-op:${Versioning.CHUCK_VERSION}"
    }

    fun DependencyHandler.androidx() {
        implementation(ANDROID_CORE_KTX)
        implementation(CONSTRAINT_LAYOUT)
        implementation(RECYCLER_VIEW)
        implementation(FRAGMENT)
    }

    fun DependencyHandler.lifecycle() {
        implementation(Lifecyle.LIFECYCLE_VIEWMODEL)
        implementation(Lifecyle.LIFECYCLE_VIEWMODEL_KTX)
        implementation(Lifecyle.LIFECYCLE_COMMON_JAVA8)
    }

    fun DependencyHandler.hilt() {
        implementation(DependencyInjection.HILT)
        kapt(DependencyInjection.HILT_COMPILER)
    }

    fun DependencyHandler.kotlin() {
        api(Kotlin.KOTLIN_JAVA8)
        api(Kotlin.KOTLIN_REFLECT)
    }

    fun DependencyHandler.retrofit() {
        implementation(Network.RETROFIT)
        implementation(Network.RETROFIT_CONVERTER_MOSHI)
        implementation(Network.RETROFIT_CONVERTER_GSON)
        implementation(Network.OKHTTP3_LOGGING_INTERCEPTOR)
    }

    fun DependencyHandler.moshi() {
        implementation(Network.MOSHI)
        implementation(Network.MOSHI_KOTLIN)
    }

    fun DependencyHandler.debugTools() {
        implementation(DebugTools.CHUCK_RELEASE_NO_OP)
        implementation(DebugTools.CHUCK_DEBUG)
    }

    fun DependencyHandler.androidCore() = implementation(ANDROID_CORE_KTX)
    fun DependencyHandler.appCompat() = implementation(ANDROIDX_APP_COMPAT)
    fun DependencyHandler.materialDesign() = api(MATERIAL_DESIGN)
    fun DependencyHandler.coroutines() = implementation(Kotlin.COROUTINES_CORE)

}
