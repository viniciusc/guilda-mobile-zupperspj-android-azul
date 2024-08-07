package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse
import com.guilda.zup.tmdbguildapjazul.model.Destination
import com.guilda.zup.tmdbguildapjazul.model.UiState
import com.guilda.zup.tmdbguildapjazul.network.model.Resource

@Composable
fun ContentArea(
    modifier: Modifier = Modifier,
    destination: Destination,
    uiState: UiState<Resource<MovieSearchResponse>>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center, //alterar quando for adicionar conteudo
        horizontalAlignment = Alignment.CenterHorizontally //alterar quando for adicionar conteudo
    ) {
        if(uiState is UiState.Loading || uiState is UiState.Error) {
            destination.icon?.let { icon ->
                Icon(
                    modifier = Modifier.size(80.dp),
                    imageVector = icon,
                    contentDescription = destination.path
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            Text(
                text = destination.path,
                fontSize = 16.sp
            )
        }
    }
}