package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse
import com.guilda.zup.tmdbguildapjazul.model.Destination
import com.guilda.zup.tmdbguildapjazul.model.UiState
import com.guilda.zup.tmdbguildapjazul.network.model.Resource

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    uiState: UiState<Resource<MovieSearchResponse>>
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
                    destination = Destination.Movies,
                    uiState = uiState
                )
            }
            composable(Destination.TvShows.path) {
                ContentArea(
                    modifier = Modifier.fillMaxSize(),
                    destination = Destination.TvShows,
                    uiState = uiState
                )
            }
        }
        composable(Destination.Settings.path) {
            ContentArea(
                modifier = Modifier.fillMaxSize(),
                destination = Destination.Settings,
                uiState = uiState
            )
        }
    }
}