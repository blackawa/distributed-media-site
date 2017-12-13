package jp.blackawa.distributedmediasite.customerfront

import jp.blackawa.distributedmediasite.customerfront.application.services.SessionsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository

@Configuration
@EnableWebFluxSecurity
class SecurityConfiguration {
    @Bean
    fun reactiveAuthenticationManager(sessionsService: SessionsService): ReactiveAuthenticationManager =
        ApiReactiveAuthenticationManager(sessionsService = sessionsService)

    @Bean
    fun securityFilterChain(reactiveAuthenticationManager: ReactiveAuthenticationManager): SecurityWebFilterChain {
        val http = ServerHttpSecurity.http()
        http.securityContextRepository(WebSessionServerSecurityContextRepository())
        http.authenticationManager(reactiveAuthenticationManager)
        http.formLogin()

        http.logout()

        val authorize = http.authorizeExchange()
        authorize.pathMatchers("/").permitAll()

        return http.build()
    }
}