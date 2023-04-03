package team.study.data.network.adapter

import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.CallAdapter
import team.study.data.model.ApiResponse
import java.lang.reflect.Type

/**
 * Call adapter to create [ApiResponse] from Retrofit service result [Call]
 */
internal class ApiResponseCallAdapter<T>(
    private val successType: Type,
    private val coroutineScope: CoroutineScope,
) : CallAdapter<T, Call<ApiResponse<T>>> {

    /**  Returns the type of return value when converting an Http response to an object. */
    override fun responseType(): Type = successType

    /** Returns an instance of [Call]<[ApiResponse]<[T]>> delegates to [Call]<[T]>. */
    override fun adapt(call: Call<T>): Call<ApiResponse<T>> {
        return ApiResponseCall(call, coroutineScope)
    }
}
