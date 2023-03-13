package team.study.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import team.study.data.BuildConfig
import team.study.data.model.SearchResponse

interface BookService {

    @GET("v1/search/book.json")
    @Headers(
        "X-Naver-Client-Id: ${BuildConfig.CLIENT_ID}",
        "X-Naver-Client_Secret: ${BuildConfig.API_KEY}",
    )
    suspend fun getSearchBooks(
        @Query("query") query: String,
    ): Response<SearchResponse>
}
