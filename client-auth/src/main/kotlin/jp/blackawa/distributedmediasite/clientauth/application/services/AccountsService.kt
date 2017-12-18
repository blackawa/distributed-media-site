package jp.blackawa.distributedmediasite.clientauth.application.services

import jp.blackawa.distributedmediasite.clientauth.infrastructure.entities.Account
import jp.blackawa.distributedmediasite.clientauth.infrastructure.repositories.AccountsRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountsService(
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val accountsRepository: AccountsRepository
) {
    fun create(email: String, password: String, roles: Array<String>): Long {
        val account = accountsRepository.save(
            Account(
                email = email,
                password = bCryptPasswordEncoder.encode(password)
            )
        )
        // TODO: save roles
        return account.id
    }
}