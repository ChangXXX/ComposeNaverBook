package team.study.data.datasource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import team.study.data.di.CustomDispatchers
import team.study.data.di.Dispatcher
import team.study.data.model.NetworkResult
import team.study.data.model.SearchResponse
import team.study.data.network.BookService
import javax.inject.Inject

class BookRemoteDataSourceImpl @Inject constructor(
    private val bookService: BookService,
    @Dispatcher(CustomDispatchers.IO) private val ioDispatchers: CoroutineDispatcher,
) : BookRemoteDataSource {

    override suspend fun searchBooks(query: String): NetworkResult<SearchResponse> =
        withContext(ioDispatchers) {
            bookService.searchBooks(query)
        }
}
