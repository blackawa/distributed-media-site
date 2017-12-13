package jp.blackawa.distributedmediasite.customerfront.datasource.repositories

import jp.blackawa.distributedmediasite.customerfront.application.requests.sessions.CreateRequest
import jp.blackawa.distributedmediasite.customerfront.datasource.entities.Session
import org.springframework.http.MediaType
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Repository
class SessionsRepository {
    fun save(request: CreateRequest) = WebClient.create("/sessions").post()
        .body(fromObject(request))
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .flatMap { res ->
            val token = res.headers().header("Authorization").first().removePrefix("Bearer ")
            Mono.just(Session(token = token))
        }
}