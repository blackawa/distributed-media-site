package jp.blackawa.distributedmediasite.auth.application.services

import jp.blackawa.distributedmediasite.auth.datasource.repositories.AccountsRepository
import jp.blackawa.distributedmediasite.auth.presentation.exceptions.BadRequestException
import jp.blackawa.distributedmediasite.auth.presentation.response.BadRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class SessionsService(
    private val accountsRepository: AccountsRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val tokensService: TokensService
) {
    fun create(username: String, password: String): String {
        val account = accountsRepository.findByUsername(username) ?: throw BadRequestException(
            listOf(BadRequest(key = "username", value = username, messages = listOf("username or password invalid.")))
        )
        if (!bCryptPasswordEncoder.matches(password, account.password))
            throw BadRequestException(
                listOf(BadRequest(key = "username", value = username, messages = listOf("username or password invalid.")))
            )

        return tokensService.create(account.id.toString())
    }
}