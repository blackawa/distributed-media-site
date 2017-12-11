package jp.blackawa.distributedmediasite.auth.presentation.controllers

import jp.blackawa.distributedmediasite.auth.presentation.exceptions.BadRequestException
import jp.blackawa.distributedmediasite.auth.presentation.response.BadRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(BadRequestException::class)
    fun catch(r: HttpServletRequest, e: BadRequestException): ResponseEntity<List<BadRequest>> {
        return e.createResponse()
    }

    @ExceptionHandler(Exception::class)
    fun catch(r: HttpServletRequest, e: Exception): ResponseEntity<Map<String, String>> {
        return ResponseEntity(mapOf(Pair("message", "unexpected error: ${e.message}")), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}