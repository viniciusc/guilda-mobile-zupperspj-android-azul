package com.guilda.zup.tmdbguildapjazul.ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.guilda.zup.tmdbguildapjazul.MovieDetailActivity
import com.guilda.zup.tmdbguildapjazul.data.repository.model.Movie
import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse

@Composable
fun MovieRow(movies: MovieSearchResponse, section: String) {
    val context = LocalContext.current
    Column(
        modifier = Modifier,

    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = section,
            fontSize = 20.sp,
            fontWeight = Bold,
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(movies.results) { movie ->
                MovieItem(movie = movie) { selectedMovie ->
                    val intent = Intent(context, MovieDetailActivity::class.java).apply {
                        putExtra("movie", selectedMovie)
                    }
                    context.startActivity(intent)

                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onClick: (Movie) -> Unit) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onClick(movie) }
    ) {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .width(80.dp)
                .padding(4.dp)
        ) {
            val baseUrlLocation = "https://image.tmdb.org/t/p/original/"
            val painter = rememberAsyncImagePainter(
                baseUrlLocation + movie.posterPath
            )
            Column(
                modifier = Modifier
            ) {
                Image(
                    painter = painter,
                    contentDescription = movie.title,
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    contentScale = ContentScale.FillHeight,
                    alignment = Alignment.Center
                )
                Text(
                    text = movie.title,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 4.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

