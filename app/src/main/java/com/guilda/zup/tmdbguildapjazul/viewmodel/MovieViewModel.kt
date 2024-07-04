package com.guilda.zup.tmdbguildapjazul.viewmodel

import androidx.lifecycle.viewModelScope
import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse
import com.guilda.zup.tmdbguildapjazul.model.UiState
import com.guilda.zup.tmdbguildapjazul.network.model.Resource
import com.guilda.zup.tmdbguildapjazul.usecase.MoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MovieViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase) : BaseViewModel<Resource<MovieSearchResponse>>(moviesUseCase) {

    private val _uiStateLiveData = MutableStateFlow<UiState<Resource<MovieSearchResponse>>>(UiState.Loading)

    val uiStateLiveData: StateFlow<UiState<Resource<MovieSearchResponse>>> = _uiStateLiveData

    init {
        viewModelScope.launch {

            moviesUseCase.getTopMovies().collect { uiState ->
                _uiStateLiveData.value = uiState
            }
        }
    }
}