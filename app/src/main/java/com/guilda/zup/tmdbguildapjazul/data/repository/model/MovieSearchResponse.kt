package com.guilda.zup.tmdbguildapjazul.data.repository.model

data class MovieSearchResponse(
    val page: Int,
    val results: List<Movie>
)