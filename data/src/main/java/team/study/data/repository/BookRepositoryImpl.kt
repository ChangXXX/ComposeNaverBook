package team.study.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import team.study.data.datasource.BookRemoteDataSource
import team.study.data.model.ApiResponse
import team.study.data.network.di.CustomDispatchers
import team.study.data.network.di.Dispatcher
import team.study.data.util.mapper.mapper
import team.study.data.util.mapper.toDomain
import team.study.domain.model.Book
import team.study.domain.repository.BookRepository
import timber.log.Timber
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookRemoteDataSource: BookRemoteDataSource,
    @Dispatcher(CustomDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
) : BookRepository {

    override suspend fun search(
        query: String,
        onException: (String?) -> Unit,
    ): Flow<List<Book>> = flow {
        when (val response = bookRemoteDataSource.searchBooks(query)) {
            is ApiResponse.Success -> {
                emit(response.data.items.map { it.toDomain() })
            }
            is ApiResponse.Failure.Error -> {
                Timber.tag("Search ApiResponse Failure.Error ::").e(response.mapper().message)
                onException(response.mapper().toString())
            }
            is ApiResponse.Failure.Exception -> {
                Timber.tag("Search ApiResponse Failure.Exception ::").e(response.toString())
                onException(response.toString())
            }
        }
    }.flowOn(ioDispatcher)
}
