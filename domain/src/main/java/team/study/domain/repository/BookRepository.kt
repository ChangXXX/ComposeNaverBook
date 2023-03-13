package team.study.domain.repository

interface BookRepository {

    /**
     * search book
     */
    suspend fun search(query: String)
}
