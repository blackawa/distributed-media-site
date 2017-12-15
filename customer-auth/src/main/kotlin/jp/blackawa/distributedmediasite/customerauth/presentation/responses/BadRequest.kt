package jp.blackawa.distributedmediasite.customerauth.presentation.response

data class BadRequest(
    val key: String = "",
    val value: String = "",
    val messages: List<String> = listOf()
)