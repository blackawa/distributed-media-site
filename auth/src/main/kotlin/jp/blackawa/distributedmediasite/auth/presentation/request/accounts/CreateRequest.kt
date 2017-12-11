package jp.blackawa.distributedmediasite.auth.presentation.request.accounts

import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull

data class CreateRequest(
    @get:NotNull
    @get:Length(min = 1, max = 60)
    val username: String = "",
    @get:NotNull
    @get:Length(min = 8, max = 60)
    val password: String = ""
)