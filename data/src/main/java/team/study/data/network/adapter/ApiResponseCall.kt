package team.study.data.network.adapter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse
import team.study.data.model.ApiResponse

internal class ApiResponseCall<T> constructor(
    private val call: Call<T>,
    private val coroutineScope: CoroutineScope,
) : Call<ApiResponse<T>> {

    override fun enqueue(callback: Callback<ApiResponse<T>>) {
        coroutineScope.launch {
            try {
                val response = call.awaitResponse()
                callback.onResponse(
                    this@ApiResponseCall,
                    Response.success(ApiResponse.from(response)),
                )
            } catch (e: Exception) {
                callback.onResponse(
                    this@ApiResponseCall,
                    Response.success(ApiResponse.Failure.Exception(e)),
                )
            }
        }
    }

    // 동기로 실행시 예외 발생
    override fun execute(): Response<ApiResponse<T>> {
        throw UnsupportedOperationException("ApiResponseCall doesn't support execute()")
    }

    override fun clone(): Call<ApiResponse<T>> {
        return ApiResponseCall(call.clone(), coroutineScope)
    }

    override fun isExecuted(): Boolean = call.isExecuted

    override fun cancel() = call.cancel()

    override fun isCanceled(): Boolean = call.isCanceled

    override fun request(): Request = call.request()

    override fun timeout(): Timeout = call.timeout()
}
