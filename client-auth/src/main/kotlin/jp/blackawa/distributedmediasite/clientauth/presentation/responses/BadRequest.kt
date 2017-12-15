package jp.blackawa.distributedmediasite.clientauth.presentation.responses

data class BadRequest(
    val key: String = "",
    val value: String = "",
    val messages: List<String> = listOf()
)