package team.study.data.model

import okhttp3.Headers
import okhttp3.ResponseBody
import retrofit2.Response

sealed interface ApiResponse<out T> {
    data class Success<T>(val response: Response<T>) : ApiResponse<T> {
        val statusCode: Int = response.code()
        val headers: Headers = response.headers()
        val data: T by lazy { response.body() ?: throw Exception() }

        override fun toString(): String = "[ApiResponse.Success-$statusCode](data=$data)"
    }

    sealed interface Failure<T> : ApiResponse<T> {
        data class Error<T>(val response: Response<T>) : Failure<T> {
            val statusCode: Int = response.code()
            val headers: Headers = response.headers()
            val errorBody: ResponseBody? = response.errorBody()

            override fun toString(): String {
                val errorBody = errorBody?.string()
                return if (!errorBody.isNullOrEmpty()) {
                    errorBody
                } else {
                    "[ApiResponse.Failure.Error-$statusCode](errorResponse=$response)"
                }
            }
        }

        data class Exception<T>(val exception: Throwable) : Failure<T> {
            val message: String? = exception.localizedMessage

            override fun toString(): String = "[ApiResponse.Failure.Exception](message=$message)"
        }
    }

    companion object {
        fun <T> from(response: Response<T>): ApiResponse<T> = try {
            if (response.code() in 200..299) {
                Success(response)
            } else {
                Failure.Error(response)
            }
        } catch (e: Exception) {
            Failure.Exception(e)
        }
    }
}
