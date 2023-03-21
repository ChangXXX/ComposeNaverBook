package team.study.data.model

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class ApiError(val code: Int, val message: String?) : NetworkResult<Nothing>()
    data class NetworkError(val e: Throwable) : NetworkResult<Nothing>()
    data class UnknownError(val e: Throwable?) : NetworkResult<Nothing>()
}
