package team.study.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("total")
    val total: Int = 0,
    @SerialName("start")
    val start: Int = 0,
    @SerialName("items")
    val items: List<SearchItem> = emptyList(),
) {

    @Serializable
    data class SearchItem(
        @SerialName("title")
        val title: String = "",
        @SerialName("link")
        val link: String = "",
        @SerialName("image")
        val image: String = "",
        @SerialName("author")
        val author: String = "",
        @SerialName("discount")
        val discount: Int = 0,
        @SerialName("publisher")
        val publisher: String = "",
        @SerialName("isbn")
        val isbn: Int = 0,
        @SerialName("description")
        val description: String = "",
        @SerialName("pubdate")
        val pubdate: String = "",
    )
}
