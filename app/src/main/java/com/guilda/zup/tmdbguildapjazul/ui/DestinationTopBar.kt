package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.guilda.zup.tmdbguildapjazul.model.Destination

@Composable
fun DestinationTopBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    openDrawer: () -> Unit,
    onNavigateUp: () -> Unit,
    showSnackbar: (message: String) -> Unit
) {
    if (currentDestination.isRootDestination) {
        RootDestinationTopBar(
            currentDestination = currentDestination,
            openDrawer = {
                openDrawer()
            },
            showSnackbar = { message ->
                showSnackbar(message)
            }
        )
    } else {
        ChildDestinationTopBar(
            title = currentDestination.path,
            onNavigateUp = onNavigateUp
        )
    }
}