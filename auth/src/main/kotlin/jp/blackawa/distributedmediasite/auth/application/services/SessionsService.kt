package jp.blackawa.distributedmediasite.auth.application.services

import jp.blackawa.distributedmediasite.auth.datasource.repositories.AccountsRepository
import org.springframework.stereotype.Service
import java.io.FileInputStream
import java.time.LocalDate

@Service
class SessionsService(private val accountsRepository: AccountsRepository) {
    fun create(username: String, password: String): String {
        val account = accountsRepository.findByUsername(username)
        return ""
    }

    private fun generateToken(username: String, expire: LocalDate): String {
        val fis = FileInputStream("auth.secret")
        val key = fis.readBytes()
        return ""
    }
}