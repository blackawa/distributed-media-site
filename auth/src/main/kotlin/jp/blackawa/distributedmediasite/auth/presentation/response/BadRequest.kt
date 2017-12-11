package jp.blackawa.distributedmediasite.auth.presentation.response

data class BadRequest(
    val key: String = "",
    val value: String = "",
    val messages: List<String> = listOf()
)