package jp.blackawa.distributedmediasite.customerfront.datasource.repositories

import jp.blackawa.distributedmediasite.customerfront.EndpointConfiguration
import jp.blackawa.distributedmediasite.customerfront.application.requests.sessions.CreateRequest
import jp.blackawa.distributedmediasite.customerfront.datasource.entities.Session
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Repository
class SessionsRepository(private val endpointConfiguration: EndpointConfiguration) {
    fun save(request: CreateRequest) = WebClient.create("${endpointConfiguration.auth}/sessions").post()
        .body(fromObject(request))
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .flatMap { res ->
            if (res.statusCode() == HttpStatus.CREATED) {
                val token = res.headers().header("Authorization").first().removePrefix("Bearer ")
                Mono.just(Session(token = token))
            } else {
                Mono.empty()
            }
        }
}