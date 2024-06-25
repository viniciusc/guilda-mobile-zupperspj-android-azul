package com.guilda.zup.tmdbguildapjazul.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse
import com.guilda.zup.tmdbguildapjazul.model.Destination
import com.guilda.zup.tmdbguildapjazul.model.UiState
import com.guilda.zup.tmdbguildapjazul.network.model.Resource
import kotlinx.coroutines.launch

@Composable
fun Home(
    modifier: Modifier = Modifier,
    uiState: UiState<Resource<MovieSearchResponse>>
) {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry.value?.destination?.route?.let{
                Destination.fromString(it)
            } ?: run {
                Destination.Home
            }
        }
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState)
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            DestinationTopBar(
                modifier = Modifier.fillMaxWidth(),
                currentDestination = currentDestination,
                openDrawer = {
                    scope.launch {
                        drawerState.apply { open() }
                    }
                },
                onNavigateUp = {
                    navController.popBackStack()
                },
                showSnackbar = { message ->
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = message
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                currentDestination = currentDestination,
                onNavigate = {
                    navController.navigate(it.path) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        drawerContent = {
            DrawerContent(
                onNavigationSelected = {
                    navController.navigate(it.path)
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        },
        drawerGesturesEnabled = false
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            when (uiState) {
                is UiState.Loading -> {
                }
                is UiState.Success -> {
                    uiState.data.data?.let { MovieRow(it) }
                }
                is UiState.Error -> {

                }
            }
        }
        Navigation(
            modifier = Modifier.fillMaxSize().padding(padding),
            navController = navController,
            uiState = uiState
        )
    }
}


