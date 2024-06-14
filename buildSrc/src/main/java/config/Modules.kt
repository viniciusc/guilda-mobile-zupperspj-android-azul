package config

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Modules {
    private const val RETROFIT_NETWORK = ":network"
    fun DependencyHandler.retrofitNetwork() = implementation(project(RETROFIT_NETWORK))
}

