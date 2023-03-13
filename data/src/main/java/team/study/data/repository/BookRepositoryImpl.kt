package team.study.data.repository

import team.study.data.di.CustomDispatchers
import team.study.data.di.Dispatcher
import team.study.data.network.BookService
import team.study.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookService: BookService,
    @Dispatcher(CustomDispatchers.IO) private val ioDispatchers: CustomDispatchers,
) : BookRepository {
    override suspend fun search(query: String) {
        TODO("Not yet implemented")
    }
}
