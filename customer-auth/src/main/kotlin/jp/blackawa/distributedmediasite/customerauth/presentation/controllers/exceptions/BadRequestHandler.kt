package jp.blackawa.distributedmediasite.auth.presentation.controllers.exceptions

import jp.blackawa.distributedmediasite.customerauth.presentation.exceptions.BadRequestException
import jp.blackawa.distributedmediasite.customerauth.presentation.response.BadRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class BadRequestHandler {
    @ExceptionHandler(BadRequestException::class)
    fun catch(r: HttpServletRequest, e: BadRequestException): ResponseEntity<List<BadRequest>> {
        return e.createResponse()
    }
}