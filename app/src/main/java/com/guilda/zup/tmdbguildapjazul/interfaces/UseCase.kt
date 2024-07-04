package com.guilda.zup.tmdbguildapjazul.interfaces

import com.guilda.zup.tmdbguildapjazul.model.UiState
import kotlinx.coroutines.flow.Flow

interface UseCase<T> {
    suspend fun getTopMovies(): Flow<UiState<T>>
}