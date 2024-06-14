package com.guilda.zup.tmdbguildapjazul.di

import android.content.Context
import com.guilda.zup.tmdbguildapjazul.data.repository.MoviesRepository
import com.guilda.zup.tmdbguildapjazul.data.repository.MoviesRepositoryImpl
import com.guilda.zup.tmdbguildapjazul.data.repository.api.ApiService
import com.guilda.zup.tmdbguildapjazul.network.ConnectionChecker
import com.guilda.zup.tmdbguildapjazul.network.retrofit.OkHttpClientFactory
import com.guilda.zup.tmdbguildapjazul.network.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor = HttpLoggingInterceptor()

    @Provides
    @Singleton
    fun provideConnectionChecker(context: Context): ConnectionChecker {
        return ConnectionChecker(context)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor, connectionChecker: ConnectionChecker, context: Context): OkHttpClient {
        return OkHttpClientFactory.build(interceptor, connectionChecker, context)
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return RetrofitClient.build("https://api.themoviedb.org/3/", okHttpClient, moshiConverterFactory)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(connectionChecker: ConnectionChecker, api: ApiService): MoviesRepository {
        return MoviesRepositoryImpl(connectionChecker, api)
    }
}