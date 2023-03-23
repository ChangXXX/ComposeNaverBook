package team.study.data.model

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>() {

        override fun toString(): String {
            return "Success data : $data"
        }
    }

    data class ApiError(val code: Int, val message: String?) : NetworkResult<Nothing>() {

        override fun toString(): String {
            return "Error code : $code / message : $message"
        }
    }

    data class NetworkError(val e: Throwable) : NetworkResult<Nothing>() {

        override fun toString(): String {
            return "NetworkError : $e"
        }
    }

    data class UnknownError(val e: Throwable?) : NetworkResult<Nothing>() {

        override fun toString(): String {
            return "UnknownError : $e"
        }
    }
}
