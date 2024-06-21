package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.guilda.zup.tmdbguildapjazul.model.Destination

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onNavigate: (destination: Destination) -> Unit
) {
    BottomNavigation(
        modifier = modifier
    ) {
        listOf(
            Destination.Movies,
            Destination.TvShows,
        ).forEach {
            BottomNavigationItem(
                selected = currentDestination.path == it.path,
                icon = {
                    it.icon?.let { image ->
                        Icon(
                            imageVector = image,
                            contentDescription = it.path
                        )
                    }
                },
                onClick = { onNavigate(it) },
                label = {
                    Text(text = it.path)
                }
            )
        }
    }
}