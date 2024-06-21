package com.guilda.zup.tmdbguildapjazul.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    fun build(url: String, client: OkHttpClient, moshiConverter: MoshiConverterFactory) =
        Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(moshiConverter)
            .build()

}