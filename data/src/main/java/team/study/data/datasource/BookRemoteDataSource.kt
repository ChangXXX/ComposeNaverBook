package team.study.data.datasource

import team.study.data.model.ApiResponse
import team.study.data.model.SearchResponse

interface BookRemoteDataSource {

    suspend fun searchBooks(query: String): ApiResponse<SearchResponse>
}
