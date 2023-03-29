package team.study.data.network

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import team.study.data.model.NetworkResult

internal class NetworkResultCall<T> constructor(
    private val call: Call<T>,
) : Call<NetworkResult<T>> {

    override fun enqueue(callback: Callback<NetworkResult<T>>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                response.body()?.let {
                    when (response.code()) {
                        200 -> { // 정상 호출
                            callback.onResponse(
                                this@NetworkResultCall,
                                Response.success(NetworkResult.Success(it)),
                            )
                        }
                        in 400..500 -> { // 비정상 호출
                            callback.onResponse(
                                this@NetworkResultCall,
                                Response.success(
                                    NetworkResult.ApiError(
                                        response.code(),
                                        response.message(),
                                    ),
                                ),
                            )
                        }
                        else -> { // 알 수 없는 오류
                            callback.onResponse(
                                this@NetworkResultCall,
                                Response.success(
                                    NetworkResult.UnknownError(
                                        Exception(response.message()),
                                    ),
                                ),
                            )
                        }
                    }
                } ?: callback.onResponse(
                    this@NetworkResultCall,
                    Response.success(NetworkResult.ApiError(response.code(), response.message())),
                )
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                callback.onResponse(
                    this@NetworkResultCall,
                    Response.success(NetworkResult.NetworkError(t)),
                )
                call.cancel()
            }
        })
    }

    // 동기로 실행시 예외 발생
    override fun execute(): Response<NetworkResult<T>> {
        throw UnsupportedOperationException("NetworkResultCall doesn't support execute()")
    }

    override fun clone(): Call<NetworkResult<T>> {
        return NetworkResultCall(call.clone())
    }

    override fun isExecuted(): Boolean = call.isExecuted

    override fun cancel() = call.cancel()

    override fun isCanceled(): Boolean = call.isCanceled

    override fun request(): Request = call.request()

    override fun timeout(): Timeout = call.timeout()
}
