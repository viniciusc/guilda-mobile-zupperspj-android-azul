package com.guilda.zup.tmdbguildapjazul.data.repository.model

data class GenresResponse(
    val genres: List<Genre>
)
fun GenresResponse.genresMap() = this.genres.associateBy({ it.id }, { it.name })
