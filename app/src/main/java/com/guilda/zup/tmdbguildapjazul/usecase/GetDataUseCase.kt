package com.guilda.zup.tmdbguildapjazul.usecase

import com.guilda.zup.tmdbguildapjazul.interfaces.UseCase
import com.guilda.zup.tmdbguildapjazul.model.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class GetDataUseCase : UseCase<String> {
    //TODO: create repository
    override fun getData(): Flow<UiState<String>> {
        return flow {
            emit(UiState.Loading)
            emit(UiState.Success("UserName"))
        }.onStart { emit(UiState.Loading) }
            .catch { e -> emit(UiState.Error("Fatal error${e.cause}")) }
    }
}