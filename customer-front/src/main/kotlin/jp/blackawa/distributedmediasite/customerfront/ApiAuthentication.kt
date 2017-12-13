package jp.blackawa.distributedmediasite.customerfront

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class ApiAuthentication(
    private val principal: String,
    private val credentials: String,
    authorities: List<GrantedAuthority>
) : AbstractAuthenticationToken(authorities) {
    override fun getCredentials() = credentials
    override fun getPrincipal() = principal
}