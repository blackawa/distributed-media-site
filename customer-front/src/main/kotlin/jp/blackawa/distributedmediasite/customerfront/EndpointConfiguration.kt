package jp.blackawa.distributedmediasite.customerfront

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "service.endpoint")
data class EndpointConfiguration(
    var auth: String = ""
)