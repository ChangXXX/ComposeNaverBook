package team.study.data.util.mapper

import team.study.data.model.ApiResponse
import team.study.data.model.ErrorMessage
import team.study.data.model.NaverError

fun ApiResponse.Failure.Error<*>.mapper(): ErrorMessage {
    val msg = when (this.statusCode) {
        NaverError.BAD_REQUEST.code -> NaverError.BAD_REQUEST.msg
        NaverError.UNAUTHORIZED.code -> NaverError.UNAUTHORIZED.msg
        NaverError.FORBIDDEN.code -> NaverError.FORBIDDEN.msg
        NaverError.NOT_FOUND.code -> NaverError.METHOD_NOT_ALLOWED.msg
        NaverError.METHOD_NOT_ALLOWED.code -> NaverError.METHOD_NOT_ALLOWED.code
        NaverError.MANY_REQUEST.code -> NaverError.MANY_REQUEST.msg
        NaverError.INTERNAL_SERVER_ERROR.code -> NaverError.INTERNAL_SERVER_ERROR.msg
        else -> "알 수 없는 오류"
    }

    return ErrorMessage(code = this.statusCode, message = msg.toString())
}
