package com.guilda.zup.tmdbguildapjazul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.guilda.zup.tmdbguildapjazul.data.repository.model.Movie
import com.guilda.zup.tmdbguildapjazul.ui.MovieDetailScreen

class MovieDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie = intent.getParcelableExtra<Movie>("movie")
        setContent {
            movie?.let {
                MovieDetailScreen(
                    movie = it,
                    onNavigateUp = { onBackPressedDispatcher.onBackPressed() })
            }
        }
    }
}