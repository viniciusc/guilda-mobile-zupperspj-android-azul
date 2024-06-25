package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.guilda.zup.tmdbguildapjazul.data.repository.model.Movie
import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse

@Composable
fun MovieRow(movies: MovieSearchResponse) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(movies.results) { movie ->
            MovieItem(movie = movie)
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = if (movie.title.length > 10) "${movie.title.take(15)}..." else movie.title,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 4.dp).fillMaxWidth(),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Box(
            modifier = Modifier
                .size(120.dp)
                .padding(4.dp)
        ) {
            val baseUrlLocation = "https://image.tmdb.org/t/p/original/"
            val painter = rememberAsyncImagePainter(
                baseUrlLocation + movie.posterPath
            )
            Image(
                painter = painter,
                contentDescription = movie.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }
    }
}

