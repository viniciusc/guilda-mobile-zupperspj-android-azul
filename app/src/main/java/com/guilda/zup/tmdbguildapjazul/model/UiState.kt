package com.guilda.zup.tmdbguildapjazul.model

sealed class UiState<out T> {

    data class Error(
        val errorMessage: String
    ) : UiState<Nothing>()

    data class Success<T>(val data: T) :
        UiState<T>()

    data object Loading : UiState<Nothing>()

}