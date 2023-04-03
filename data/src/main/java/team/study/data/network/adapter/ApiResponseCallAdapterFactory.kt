package team.study.data.network.adapter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import team.study.data.model.ApiResponse
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ApiResponseCallAdapterFactory private constructor(
    private val coroutineScope: CoroutineScope,
) : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit,
    ): CallAdapter<*, *>? {
        if (Call::class.java != getRawType(returnType)) {
            return null
        }

        val callType = getParameterUpperBound(0, returnType as ParameterizedType)

        if (getRawType(callType) != ApiResponse::class.java) {
            return null
        }

        val resultType = getParameterUpperBound(0, callType as ParameterizedType)

        return ApiResponseCallAdapter<Any>(resultType, coroutineScope)
    }

    companion object {
        fun create(
            coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
        ): ApiResponseCallAdapterFactory = ApiResponseCallAdapterFactory(coroutineScope)
    }
}
