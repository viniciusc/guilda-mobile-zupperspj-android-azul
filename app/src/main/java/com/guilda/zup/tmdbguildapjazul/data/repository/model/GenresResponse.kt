package com.guilda.zup.tmdbguildapjazul.data.repository.model

data class GenresResponse(
    val genres: List<Genre>
)

typealias GenresMap = Map<Int, String>
fun GenresResponse.genresMap(): GenresMap = this.genres.associateBy({ it.id }, { it.name })
