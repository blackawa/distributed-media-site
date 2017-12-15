package jp.blackawa.distributedmediasite.clientauth.presentation.controllers.accounts

import jp.blackawa.distributedmediasite.clientauth.application.extensions.badRequests
import jp.blackawa.distributedmediasite.clientauth.presentation.exceptions.BadRequestException
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController("accounts/create")
class CreateController {
    @PostMapping("/accounts")
    fun create(
        @Valid @RequestBody createRequest: CreateRequest, bindingResult: BindingResult
    ): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            throw BadRequestException(bindingResult.badRequests())
        }
        TODO()
    }
}