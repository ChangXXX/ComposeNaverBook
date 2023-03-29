package team.study.data.network.di

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import team.study.data.BuildConfig
import team.study.data.network.HeaderInterceptor
import javax.inject.Singleton

class ClientModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
            builder.addInterceptor(logging)
            builder.addInterceptor(OkHttpProfilerInterceptor())
        }

        return builder.build()
    }
}
