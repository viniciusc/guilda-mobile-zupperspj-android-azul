package com.guilda.zup.tmdbguildapjazul.network.retrofit

import com.guilda.zup.tmdbguildapjazul.network.BuildConfig

import okhttp3.Interceptor
import okhttp3.Response
class AuthInterceptor(
    private val token: String = BuildConfig.TMDB_BEARER_TOKEN,
    private val apiKey: String = BuildConfig.TMDB_API_KEY
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()
        request = chain.request().newBuilder()
            .url(url)
            .addHeader("Authorization", "Bearer $token}")
            .addHeader("accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}