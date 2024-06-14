package com.guilda.zup.tmdbguildapjazul.data.repository.model

data class Movie(
    val adult: Boolean,
    val backdropPath: String?,
    val genreIds: List<Double>,
    val id: Double,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Double
)