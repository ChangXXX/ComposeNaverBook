package team.study.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import team.study.data.model.NetworkResult
import team.study.data.model.SearchResponse

interface BookService {

    @GET("v1/search/book.json")
    suspend fun searchBooks(
        @Query("query") query: String,
    ): NetworkResult<SearchResponse>
}
