package jp.blackawa.distributedmediasite.customerfront

import jp.blackawa.distributedmediasite.customerfront.application.services.SessionsService
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.AuthorityUtils
import reactor.core.publisher.Mono

class ApiReactiveAuthenticationManager(private val sessionsService: SessionsService) : ReactiveAuthenticationManager {
    override fun authenticate(authentication: Authentication): Mono<Authentication> {
        val username = authentication.name
        val password = authentication.credentials as String
        return sessionsService.create(username, password)
            .switchIfEmpty(Mono.error(BadCredentialsException("Invalid Credentials")))
            .map { session ->
                ApiAuthentication(
                    "", session.token, AuthorityUtils.createAuthorityList("ROLE_ACCOUNT")
                )
            }
    }
}