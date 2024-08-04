package com.guilda.zup.tmdbguildapjazul.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.guilda.zup.tmdbguildapjazul.R
import com.guilda.zup.tmdbguildapjazul.data.repository.model.GenresMap
import com.guilda.zup.tmdbguildapjazul.data.repository.model.Movie
import com.guilda.zup.tmdbguildapjazul.data.repository.model.getGenres
import com.guilda.zup.tmdbguildapjazul.ui.theme.Typography
import com.guilda.zup.tmdbguildapjazul.util.Genres

@Composable
fun MovieDetailScreen(movie: Movie, onNavigateUp: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val baseUrlLocation = "https://image.tmdb.org/t/p/original/"
        val painter = rememberAsyncImagePainter(baseUrlLocation + movie.backdropPath)

        ChildDestinationTopBar(title = movie.title,
            onNavigateUp = onNavigateUp)
        Image(
            painter = painter,
            contentDescription = movie.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = movie.title,
            style = Typography.h5,
            modifier = Modifier.padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
        )

        Text(
            text = stringResource(R.string.rating, movie.voteAverage),
            style = Typography.body1,
            modifier = Modifier.padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
        )

        Text(
            text = stringResource(R.string.genres, movie.getGenres(Genres.getInstance()).joinToString(", ")),
            style = Typography.body1,
            modifier = Modifier.padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
        )

        Text(
            text = stringResource(R.string.original_language, movie.originalLanguage),
            style = Typography.body1,
            modifier = Modifier.padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
        )

        Text(
            text = stringResource(R.string.overview, movie.overview),
            style = Typography.body1,
            modifier = Modifier.padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
        )
    }
}