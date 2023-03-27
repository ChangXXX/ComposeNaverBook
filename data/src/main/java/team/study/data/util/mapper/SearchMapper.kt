package team.study.data.util.mapper

import team.study.data.model.SearchResponse
import team.study.domain.model.Book

fun SearchResponse.SearchItem.toDomain(): Book {
    return Book(
        title = this.title,
        link = this.link,
        image = this.image,
        author = this.author,
        discount = this.discount,
        publisher = this.publisher,
        isbn = this.isbn,
        description = this.description,
        pubdate = this.pubdate,
    )
}
