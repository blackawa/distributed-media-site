package jp.blackawa.distributedmediasite.customerfront.application.requests.sessions

data class CreateRequest(
    val username: String = "",
    val password: String = ""
)