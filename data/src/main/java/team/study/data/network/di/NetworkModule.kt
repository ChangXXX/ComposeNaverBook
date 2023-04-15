package team.study.data.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import team.study.data.network.adapter.ApiResponseCallAdapterFactory
import team.study.data.network.service.BookService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val NAVER_URL = "https://openapi.naver.com/v1/datalab/"

    private val json = Json {
        prettyPrint = true
        isLenient = true // Json 큰 따옴표 느슨한 체크
        ignoreUnknownKeys = true // Field 값이 없는 경우 무시
        coerceInputValues = true // "null" 이 들어간 경우 Default Argument 대체
        encodeDefaults = true // 요청 시 Field DefaultValue 무시 되는 경우 방지
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(NAVER_URL)
        .addConverterFactory(
            @OptIn(ExperimentalSerializationApi::class)
            json.asConverterFactory("application/json".toMediaType()),
        )
        .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideBookService(retrofit: Retrofit): BookService {
        return retrofit.create(BookService::class.java)
    }
}
