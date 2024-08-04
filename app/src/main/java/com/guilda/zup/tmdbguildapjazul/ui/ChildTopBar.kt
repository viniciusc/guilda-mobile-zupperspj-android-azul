package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.guilda.zup.tmdbguildapjazul.R

@Composable
fun ChildDestinationTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onNavigateUp: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = {
                onNavigateUp()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.voltar)
                )
            }
        }
    )
}