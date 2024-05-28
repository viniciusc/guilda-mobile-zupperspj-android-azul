package com.guilda.zup.tmdbguildapjazul.interfaces

import com.guilda.zup.tmdbguildapjazul.model.UiState
import kotlinx.coroutines.flow.Flow

interface UseCase<T> {
    fun getData(): Flow<UiState<T>>
}