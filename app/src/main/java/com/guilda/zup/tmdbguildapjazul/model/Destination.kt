package com.guilda.zup.tmdbguildapjazul.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
    val path: String,
    val icon: ImageVector? = null,
    val isRootDestination: Boolean = true
) {
    companion object {
        fun fromString(route: String): Destination {
            return when (route) {
                Movies.path -> Movies
                TvShows.path -> TvShows
                Settings.path -> Settings
                else -> Home
            }
        }
    }

    object Home: Destination("home")
    object Movies: Destination("movies", Icons.Default.List)
    object TvShows: Destination("tvshows", Icons.Default.List)
    object Settings: Destination("settings", Icons.Default.Settings, isRootDestination = false)
}