package jp.blackawa.distributedmediasite.clientauth.presentation.controllers.accounts

import jp.blackawa.distributedmediasite.clientauth.application.extensions.badRequests
import jp.blackawa.distributedmediasite.clientauth.application.services.AccountsService
import jp.blackawa.distributedmediasite.clientauth.presentation.exceptions.BadRequestException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController("accounts/create")
class CreateController(
    private val accountsService: AccountsService
) {
    @PostMapping("/accounts")
    fun create(
        @Valid @RequestBody request: CreateRequest, bindingResult: BindingResult
    ): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            throw BadRequestException(bindingResult.badRequests())
        }
        val accountId = accountsService.create(
            email = request.email,
            password = request.password,
            roles = request.roles
        )
        val headers = HttpHeaders()
        headers.add("Location", "/accounts/$accountId")
        return ResponseEntity(headers, HttpStatus.CREATED)
    }
}