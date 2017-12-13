package jp.blackawa.distributedmediasite.customerfront.application.manager

import jp.blackawa.distributedmediasite.customerfront.application.services.SessionsService
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.core.Authentication
import reactor.core.publisher.Mono

class ApiReactiveAuthenticationManager(private val sessionsService: SessionsService) : ReactiveAuthenticationManager {
    override fun authenticate(authentication: Authentication?): Mono<Authentication> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}