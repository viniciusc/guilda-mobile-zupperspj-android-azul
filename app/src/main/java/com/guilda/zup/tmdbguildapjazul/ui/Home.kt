package com.guilda.zup.tmdbguildapjazul.ui

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
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.guilda.zup.tmdbguildapjazul.model.Destination
import kotlinx.coroutines.launch

@Composable
fun Home(
    modifier: Modifier = Modifier
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
        Navigation(
            modifier = Modifier.fillMaxSize().padding(padding),
            navController = navController
        )
    }
}