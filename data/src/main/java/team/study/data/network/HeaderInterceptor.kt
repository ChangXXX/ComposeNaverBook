package team.study.data.network

import okhttp3.Interceptor
import okhttp3.Response
import team.study.data.BuildConfig

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader(NetworkHeader.CLIENT_ID, BuildConfig.CLIENT_ID)
                .addHeader(NetworkHeader.CLIENT_SECRET, BuildConfig.API_KEY)
                .build(),
        )
    }
}
