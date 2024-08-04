package com.guilda.zup.tmdbguildapjazul.util

import com.guilda.zup.tmdbguildapjazul.data.repository.model.Genre

class Genres {

    companion object {
        @Volatile
        var INSTANCE : Map<Int, String>? = null

        fun getInstance() : Map<Int, String> {
            return INSTANCE?: synchronized(this){
                val instance = mutableMapOf<Int, String>()
                INSTANCE = instance
                instance
            }
        }

        fun setInstance(genres : List<Genre>) {
            INSTANCE = genres.associate { it.id to it.name }
        }
    }
}