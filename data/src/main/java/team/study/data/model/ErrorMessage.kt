package team.study.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorMessage(
    val code: Int,
    val message: String,
)
