package team.study.domain.usecase

import kotlinx.coroutines.flow.Flow
import team.study.domain.model.Book
import team.study.domain.repository.BookRepository
import javax.inject.Inject

class BookSearchUseCase @Inject constructor(
    private val bookRepository: BookRepository,
) {
    suspend operator fun invoke(query: String, onError: (String?) -> Unit): Flow<List<Book>> {
        return bookRepository.search(query, onError)
    }
}
