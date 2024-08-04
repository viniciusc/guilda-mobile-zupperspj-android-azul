package com.guilda.zup.tmdbguildapjazul.interfaces

import com.guilda.zup.tmdbguildapjazul.data.repository.model.GenresResponse
import com.guilda.zup.tmdbguildapjazul.model.UiState
import com.guilda.zup.tmdbguildapjazul.network.model.Resource
import kotlinx.coroutines.flow.Flow

interface UseCase<T> {
    suspend fun getTopMovies(): Flow<UiState<T>>
    suspend fun getGenres(): Flow<UiState<Resource<GenresResponse>>>
}