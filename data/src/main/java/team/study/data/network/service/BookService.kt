package team.study.data.network.service

import retrofit2.http.GET
import retrofit2.http.Query
import team.study.data.model.ApiResponse
import team.study.data.model.SearchResponse

interface BookService {

    @GET("v1/search/book.json")
    suspend fun searchBooks(
        @Query("query") query: String,
        @Query("display") display: Int = 20,
        @Query("start") start: Int = 1,
        @Query("sort") sort: String = "sim", // sim - 정확도, date - 출간일
    ): ApiResponse<SearchResponse>
}
