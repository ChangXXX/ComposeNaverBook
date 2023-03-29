package team.study.data.network

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import team.study.data.model.NetworkResult
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class NetworkResultCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit,
    ): CallAdapter<*, *>? {
        if (Call::class.java != getRawType(returnType) || returnType !is ParameterizedType) return null

        val responseType = getParameterUpperBound(0, returnType)

        return if (responseType is ParameterizedType && getRawType(responseType) == NetworkResult::class.java) {
            object : CallAdapter<Any, Call<NetworkResult<*>>> {
                override fun responseType(): Type = getParameterUpperBound(0, responseType)

                override fun adapt(call: Call<Any>): Call<NetworkResult<*>> =
                    NetworkResultCall(call) as Call<NetworkResult<*>>
            }
        } else {
            null
        }
    }
}
