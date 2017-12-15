package jp.blackawa.distributedmediasite.auth.presentation.controllers

import jp.blackawa.distributedmediasite.auth.application.extensions.badRequests
import jp.blackawa.distributedmediasite.auth.application.services.SessionsService
import jp.blackawa.distributedmediasite.auth.presentation.exceptions.BadRequestException
import jp.blackawa.distributedmediasite.auth.presentation.request.sessions.CreateRequest
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/sessions")
class SessionsController(
    private val sessionsService: SessionsService
) {
    @PostMapping(
        produces = [MediaType.APPLICATION_JSON_UTF8_VALUE],
        consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE]
    )
    fun create(
        @Valid @RequestBody request: CreateRequest, bindingResult: BindingResult
    ): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            throw BadRequestException(bindingResult.badRequests())
        }
        val token = sessionsService.create(username = request.username, password = request.password)
        val headers = HttpHeaders()
        headers.add("Authorization", "Bearer $token")
        return ResponseEntity(headers, HttpStatus.CREATED)
    }
}