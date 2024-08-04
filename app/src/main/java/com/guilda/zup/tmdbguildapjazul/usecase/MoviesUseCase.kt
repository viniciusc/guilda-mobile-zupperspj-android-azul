package com.guilda.zup.tmdbguildapjazul.usecase

import com.guilda.zup.tmdbguildapjazul.data.repository.MoviesRepository
import com.guilda.zup.tmdbguildapjazul.data.repository.model.GenresResponse
import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse
import com.guilda.zup.tmdbguildapjazul.data.repository.model.genresMap
import com.guilda.zup.tmdbguildapjazul.interfaces.UseCase
import com.guilda.zup.tmdbguildapjazul.model.UiState
import com.guilda.zup.tmdbguildapjazul.network.model.Resource
import com.guilda.zup.tmdbguildapjazul.util.Genres
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository):
    UseCase<Resource<MovieSearchResponse>> {

    override suspend fun getTopMovies(): Flow<UiState<Resource<MovieSearchResponse>>> {
        return flow {
            emit(UiState.Loading)
            val movie = moviesRepository.getTopMovies()
            emit(UiState.Success(movie))

        }.onStart { emit(UiState.Loading) }
            .catch { e -> emit(UiState.Error("Fatal error${e.cause}")) }
    }

    override suspend fun getGenres(): Flow<UiState<Resource<GenresResponse>>> {
        return flow {
            emit(UiState.Loading)
            val genres = moviesRepository.getGenres()
            genres.data?.let {
                Genres.setInstance(it.genres)
            }
            emit(UiState.Success(genres))
        }.onStart { emit(UiState.Loading) }
            .catch { e -> emit(UiState.Error("Fatal error${e.cause}")) }
    }
}