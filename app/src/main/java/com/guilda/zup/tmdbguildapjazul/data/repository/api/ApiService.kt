package com.guilda.zup.tmdbguildapjazul.data.repository.api

import com.guilda.zup.tmdbguildapjazul.data.repository.model.GenresResponse
import com.guilda.zup.tmdbguildapjazul.data.repository.model.MovieSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("language") language: String = "pt-BR",
        ): Response<MovieSearchResponse>

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("language") language: String = "pt-BR",
    ): Response<GenresResponse>

    @GET("movie/top_rated")
    suspend fun getTopMovies(@Query("language") language: String = "pt-BR"
    ) : Response<MovieSearchResponse>
}