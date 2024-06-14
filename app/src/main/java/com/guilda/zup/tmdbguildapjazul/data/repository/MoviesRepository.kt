package com.guilda.zup.tmdbguildapjazul.data.repository

import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse
import com.guilda.zup.tmdbguildapjazul.network.model.Resource

interface MoviesRepository {

    suspend fun searchMovie(query: String): Resource<MovieSearchResponse>
}