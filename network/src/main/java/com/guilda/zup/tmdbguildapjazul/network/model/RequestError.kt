package com.guilda.zup.tmdbguildapjazul.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
class RequestError(

    @field:Json(name = "code")
    val code: Int = -1,

    val title: String = "ops!",

    @field:Json(name = "status_message")
    val message: String = "Aconteceu um erro :/"

) : Parcelable