package com.guilda.zup.tmdbguildapjazul

import com.guilda.zup.tmdbguildapjazul.viewmodel.MainViewModel
import com.guilda.zup.tmdbguildapjazul.factory.MainViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.guilda.zup.tmdbguildapjazul.theme.ComposeByExampleTheme
import com.guilda.zup.tmdbguildapjazul.ui.Home
import com.guilda.zup.tmdbguildapjazul.model.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetUiLiveState(viewModel = viewModel)
            ComposeByExampleTheme {
                Home(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun GetUiLiveState(viewModel: MainViewModel){
    val uiState by viewModel.uiStateLiveData.collectAsState(initial = UiState.Loading)
    println(uiState)
}