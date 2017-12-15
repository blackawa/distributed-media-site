package jp.blackawa.distributedmediasite.auth.presentation.controllers.sessions

data class CreateRequest(
    val username: String = "",
    val password: String = ""
)