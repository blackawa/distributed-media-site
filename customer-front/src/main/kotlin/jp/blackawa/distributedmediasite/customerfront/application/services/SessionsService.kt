package jp.blackawa.distributedmediasite.customerfront.application.services

import jp.blackawa.distributedmediasite.customerfront.application.requests.sessions.CreateRequest
import jp.blackawa.distributedmediasite.customerfront.datasource.entities.Session
import jp.blackawa.distributedmediasite.customerfront.datasource.repositories.SessionsRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class SessionsService(private val sessionsRepository: SessionsRepository) {
    fun create(username: String, password: String): Mono<Session> {
        return sessionsRepository.save(CreateRequest(username = username, password = password))
    }
}