package team.study.domain.repository

import kotlinx.coroutines.flow.Flow
import team.study.domain.model.Book

interface BookRepository {

    /**
     * search book
     */
    suspend fun search(query: String, onError: (String?) -> Unit): Flow<List<Book>>
}
