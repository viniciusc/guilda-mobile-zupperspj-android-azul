package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.guilda.zup.tmdbguildapjazul.model.Destination

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Destination.Home.path
    ) {
        navigation(
            startDestination = Destination.Movies.path,
            route = Destination.Home.path,
        ) {
            composable(Destination.Movies.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.Movies
                )
            }
            composable(Destination.TvShows.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.TvShows
                )
            }
        }
        composable(Destination.Settings.path) {
            ContentArea(
                modifier = Modifier.fillMaxSize(),
                destination = Destination.Settings
            )
        }
    }
}