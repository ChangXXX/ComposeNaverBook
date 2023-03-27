package team.study.domain.model

data class Book(
    val title: String = "",
    val link: String = "",
    val image: String = "",
    val author: String = "",
    val discount: Int = 0,
    val publisher: String = "",
    val isbn: Int = 0,
    val description: String = "",
    val pubdate: String = "",
)
