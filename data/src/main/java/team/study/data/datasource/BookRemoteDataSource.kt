package team.study.data.datasource

import team.study.data.model.NetworkResult
import team.study.data.model.SearchResponse

interface BookRemoteDataSource {

    suspend fun searchBooks(query: String): NetworkResult<SearchResponse>
}
