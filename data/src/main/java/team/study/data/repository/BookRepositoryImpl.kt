package team.study.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import team.study.data.datasource.BookRemoteDataSource
import team.study.data.model.NetworkResult
import team.study.data.util.mapper.toDomain
import team.study.domain.model.Book
import team.study.domain.repository.BookRepository
import timber.log.Timber
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookRemoteDataSource: BookRemoteDataSource,
) : BookRepository {

    override suspend fun search(
        query: String,
    ): Flow<List<Book>> = flow {
        bookRemoteDataSource.searchBooks(query).let { result ->
            when (result) {
                is NetworkResult.Success -> {
                    emit(
                        result.data.items.map { searchItem ->
                            searchItem.toDomain()
                        },
                    )
                }
                is NetworkResult.ApiError -> {
                    Timber.e(result.toString())
                }
                is NetworkResult.NetworkError -> {
                    Timber.e(result.toString())
                }
                is NetworkResult.UnknownError -> {
                    Timber.e(result.toString())
                }
            }
        }
    }
}
