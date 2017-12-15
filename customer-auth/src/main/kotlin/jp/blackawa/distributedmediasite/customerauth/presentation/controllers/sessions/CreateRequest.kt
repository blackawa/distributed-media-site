package jp.blackawa.distributedmediasite.customerauth.presentation.controllers.sessions

data class CreateRequest(
    val username: String = "",
    val password: String = ""
)