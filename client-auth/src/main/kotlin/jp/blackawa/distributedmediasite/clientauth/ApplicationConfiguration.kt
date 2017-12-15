package jp.blackawa.distributedmediasite.clientauth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class ApplicationConfiguration {
    @Bean
    fun bCryptPasswordEncoder() = BCryptPasswordEncoder()
}