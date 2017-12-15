package jp.blackawa.distributedmediasite.auth.presentation.request.sessions

data class CreateRequest(
    val username: String = "",
    val password: String = ""
)