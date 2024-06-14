package com.guilda.zup.tmdbguildapjazul.data.repository

import com.guilda.zup.tmdbguildapjazul.data.repository.api.ApiService
import com.guilda.zup.tmdbguildapjazul.data.repository.model.GenresResponse
import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse
import com.guilda.zup.tmdbguildapjazul.network.ConnectionChecker
import com.guilda.zup.tmdbguildapjazul.network.model.Resource
import com.guilda.zup.tmdbguildapjazul.network.model.RetrofitResponse

class MoviesRepositoryImpl(
    private val connectionChecker: ConnectionChecker,
    private val api: ApiService) : MoviesRepository
{
    override suspend fun searchMovie(query: String): Resource<MovieSearchResponse> {
        return RetrofitResponse(connectionChecker) { api.searchMovie(query) }.result()
    }

    override suspend fun getGenres(): Resource<GenresResponse> {
        return RetrofitResponse(connectionChecker) { api.getGenres() }.result()
    }
}