package jp.blackawa.distributedmediasite.customerauth.application.services

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jp.blackawa.distributedmediasite.`customer-auth`.application.extensions.toDate
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TokensService {
    fun create(principal: String): String {
        val expire = LocalDateTime.now().plusDays(30)
        val fis = ClassLoader.getSystemResourceAsStream("auth.secret")
        val key = fis.readBytes()
        return Jwts.builder()
            .setSubject(principal)
            .setExpiration(expire.toDate())
            .signWith(SignatureAlgorithm.HS512, key)
            .compact()
    }
}