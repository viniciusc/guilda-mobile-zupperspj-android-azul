package com.guilda.zup.tmdbguildapjazul.network.retrofit

import android.content.Context
import com.guilda.zup.tmdbguildapjazul.network.ConnectionChecker
import okhttp3.Cache
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

const val FIVE_MEGA_BYTES = 5 * 1024 * 1024

object OkHttpClientFactory {

    fun build(interceptor: Interceptor, connectionChecker: ConnectionChecker, context: Context): OkHttpClient {
        val cacheSize = FIVE_MEGA_BYTES.toLong()
        val myCache = Cache(context.cacheDir, cacheSize)

        val clientBuilder = OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                val cacheControlValue = if (connectionChecker.hasInternetConnection()) "public, max-age=${5}" else "public, only-if-cached, max-stale=${60*2}"
                chain.proceed(chain
                    .request()
                    .newBuilder()
                    .header("Cache-Control", cacheControlValue)
                    .build())
            }
            .dispatcher(Dispatcher().apply { maxRequests = 1 })
            .readTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(interceptor)
            .addInterceptor(AuthInterceptor())

        return clientBuilder.build()
    }


}