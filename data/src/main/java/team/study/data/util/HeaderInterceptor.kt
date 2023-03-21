package team.study.data.util

import okhttp3.Interceptor
import okhttp3.Response
import team.study.data.BuildConfig

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("X-Naver-Client-Id", BuildConfig.CLIENT_ID)
                .addHeader("X-Naver-Client_Secret:", BuildConfig.API_KEY)
                .build(),
        )
    }
}
