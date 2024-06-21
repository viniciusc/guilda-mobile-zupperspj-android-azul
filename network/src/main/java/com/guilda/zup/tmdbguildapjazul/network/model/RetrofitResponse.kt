package com.guilda.zup.tmdbguildapjazul.network.model

import com.squareup.moshi.JsonEncodingException
import com.guilda.zup.tmdbguildapjazul.network.ConnectionChecker
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException

class RetrofitResponse<T>(
    private val connectionChecker: ConnectionChecker,
    private val request: suspend () -> Response<T>
) : ApiResponse<T> {

    override suspend fun result(): Resource<T> {
        return try {
            val response = request.invoke()
            val data = response.body()

            if (response.isSuccessful && data != null) {
                success(data)
            } else {
                error(response.code(), response.errorBody())
            }
        } catch (exception: Exception) {
            failure(exception)
        }
    }

    override fun success(data: T) = Resource.success(data)

    override fun error(code: Int, errorBody: ResponseBody?): Resource<T> {
        return Resource.error(genericError)
    }

    override fun failure(exception: Exception): Resource<T> {
        return when (exception) {
            is JsonEncodingException -> {
                Resource.error(genericError)
            }
            is UnknownHostException, is IOException -> {
                Resource.error(verifyInternetConnection())
            }
            else -> {
                Resource.error(genericError)
            }
        }
    }

    private fun verifyInternetConnection(): RequestError {
        return if (connectionChecker.hasInternetConnection()) {
            genericError
        } else {
            connectionError
        }
    }

    companion object {

        val connectionError: RequestError
            get() = RequestError(
                code = 401,
                title = "Connection error",
                message = "Could not connect to the server. Check your internet connection."
            )

        val genericError : RequestError
            get() = RequestError(
                code = 400,
                title = "Ops, something get wrong",
                message = "Try again later",
            )

    }
}