package team.study.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import team.study.data.BuildConfig
import team.study.data.network.BookService
import team.study.data.util.HeaderInterceptor
import team.study.data.util.NetworkResultCallAdapterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val NAVER_URL = "https://openapi.naver.com/v1/datalab/"

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

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        json: Json,
        networkResultCallAdapterFactory: NetworkResultCallAdapterFactory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(NAVER_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .addCallAdapterFactory(networkResultCallAdapterFactory)
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Provides
    @Singleton
    fun provideBookService(retrofit: Retrofit): BookService {
        return retrofit.create(BookService::class.java)
    }
}
