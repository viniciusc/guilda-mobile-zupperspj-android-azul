package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.guilda.zup.tmdbguildapjazul.model.Destination

@Composable
fun RootDestinationTopBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    openDrawer: () -> Unit,
    showSnackbar: (message: String) -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "Home")
        },
        navigationIcon = {
            IconButton(onClick = {
                openDrawer()
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Open Menu"
                )
            }
        },
        actions = {
//            if (currentDestination != Destination.Movies) {
//                val snackbarMessage = "em breve"
//                IconButton(onClick = {
//                    showSnackbar(snackbarMessage)
//                }) {
//                    Icon(
//                        imageVector = Icons.Default.Info,
//                        contentDescription = stringResource(id = R.string.cd_more_info)
//                    )
//                }
//            }
        }
    )
}
