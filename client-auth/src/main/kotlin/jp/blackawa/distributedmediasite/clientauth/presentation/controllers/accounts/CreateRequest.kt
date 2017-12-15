package jp.blackawa.distributedmediasite.clientauth.presentation.controllers.accounts

import java.util.*

data class CreateRequest(
    val email: String = "",
    val password: String = "",
    val roles: Array<String> = arrayOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CreateRequest

        if (email != other.email) return false
        if (password != other.password) return false
        if (!Arrays.equals(roles, other.roles)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = email.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + Arrays.hashCode(roles)
        return result
    }
}