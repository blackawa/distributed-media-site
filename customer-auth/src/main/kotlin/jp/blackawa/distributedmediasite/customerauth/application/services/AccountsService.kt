package jp.blackawa.distributedmediasite.customerauth.application.services

import jp.blackawa.distributedmediasite.customerauth.infrastructure.entities.Account
import jp.blackawa.distributedmediasite.customerauth.infrastructure.repositories.AccountsRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountsService(
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val accountsRepository: AccountsRepository
) {
    fun create(username: String, password: String): Long {
        val account = accountsRepository.save(
            Account(
                username = username,
                password = bCryptPasswordEncoder.encode(password)
            )
        )
        return account.id
    }
}