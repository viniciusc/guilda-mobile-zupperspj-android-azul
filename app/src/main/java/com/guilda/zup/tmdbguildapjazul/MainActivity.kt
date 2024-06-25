package com.guilda.zup.tmdbguildapjazul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.guilda.zup.tmdbguildapjazul.theme.ComposeByExampleTheme
import com.guilda.zup.tmdbguildapjazul.ui.Home
import com.guilda.zup.tmdbguildapjazul.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val moviesViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val uiState by moviesViewModel.uiStateLiveData.collectAsState()

            ComposeByExampleTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    Home(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        uiState = uiState
                    )
                }
            }
        }
    }
}
