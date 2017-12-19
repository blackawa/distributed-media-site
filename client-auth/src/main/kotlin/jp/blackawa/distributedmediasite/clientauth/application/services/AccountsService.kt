package jp.blackawa.distributedmediasite.clientauth.application.services

import jp.blackawa.distributedmediasite.clientauth.infrastructure.entities.Account
import jp.blackawa.distributedmediasite.clientauth.infrastructure.repositories.AccountsRepository
import jp.blackawa.distributedmediasite.clientauth.infrastructure.repositories.RoleCodesRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class AccountsService(
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val accountsRepository: AccountsRepository,
    private val roleCodesRepository: RoleCodesRepository
) {
    @Transactional
    fun create(email: String, password: String, roles: Array<String>): Long {
        val account = accountsRepository.save(
            Account(
                email = email,
                password = bCryptPasswordEncoder.encode(password)
            )
        )
        account.roleCodes = roleCodesRepository.findAllById(roles.map { it.toLong() }.toList()).toSet()
        return account.id
    }

    @Transactional
    fun findById(id: Long): Account? {
//        return accountsRepository.findById(id).orElse(null)
        return accountsRepository.findById(id).orElse(null).let {
            val result = it.copy()
            result.roleCodes = it.roleCodes
            result
        }
    }
}