package jp.blackawa.distributedmediasite.auth.application.services

import jp.blackawa.distributedmediasite.auth.datasource.entities.Account
import jp.blackawa.distributedmediasite.auth.datasource.repositories.AccountsRepository
import jp.blackawa.distributedmediasite.auth.presentation.request.accounts.CreateRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountsService(private val accountsRepository: AccountsRepository) {
    fun create(request: CreateRequest): Long {
        val encodedPassword = BCryptPasswordEncoder().encode(request.password)
        val account = accountsRepository.save(Account(username = request.username, password = encodedPassword))
        return account.id
    }
}