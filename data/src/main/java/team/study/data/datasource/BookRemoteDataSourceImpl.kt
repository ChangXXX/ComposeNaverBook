package team.study.data.datasource

import team.study.data.model.ApiResponse
import team.study.data.model.SearchResponse
import team.study.data.network.service.BookService
import javax.inject.Inject

class BookRemoteDataSourceImpl @Inject constructor(
    private val bookService: BookService,
) : BookRemoteDataSource {

    override suspend fun searchBooks(query: String): ApiResponse<SearchResponse> =
        bookService.searchBooks(query)
}
