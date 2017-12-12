package jp.blackawa.distributedmediasite.auth.presentation.controllers

import jp.blackawa.distributedmediasite.auth.application.extensions.badRequests
import jp.blackawa.distributedmediasite.auth.application.services.AccountsService
import jp.blackawa.distributedmediasite.auth.application.services.TokensService
import jp.blackawa.distributedmediasite.auth.presentation.exceptions.BadRequestException
import jp.blackawa.distributedmediasite.auth.presentation.request.accounts.CreateRequest
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController(value = "/accounts")
class AccountsController(
    private val accountsService: AccountsService,
    private val tokensService: TokensService
) {
    @PostMapping(produces = [MediaType.APPLICATION_JSON_UTF8_VALUE], consumes = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
    fun create(@Valid @RequestBody request: CreateRequest, bindingResult: BindingResult): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            throw BadRequestException(bindingResult.badRequests())
        }
        val id = accountsService.create(request)
        val token = tokensService.create(id.toString())
        val headers = HttpHeaders()
        headers.add("location", "/accounts/$id")
        headers.add("Authorization", "Bearer $token")
        return ResponseEntity(headers, HttpStatus.CREATED)
    }
}