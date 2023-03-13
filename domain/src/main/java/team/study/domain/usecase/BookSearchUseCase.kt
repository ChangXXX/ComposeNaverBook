package team.study.domain.usecase

import team.study.domain.repository.BookRepository
import javax.inject.Inject

class BookSearchUseCase @Inject constructor(
    private val bookRepository: BookRepository,
) {

    suspend operator fun invoke(query: String) {
        bookRepository.search(query)
    }
}
