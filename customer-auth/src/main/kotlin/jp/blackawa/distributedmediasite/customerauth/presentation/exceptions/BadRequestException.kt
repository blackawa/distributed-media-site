package jp.blackawa.distributedmediasite.customerauth.presentation.exceptions

import jp.blackawa.distributedmediasite.customerauth.presentation.response.BadRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class BadRequestException(private val errors: List<BadRequest> = listOf()) : RuntimeException() {
    fun createResponse(): ResponseEntity<List<BadRequest>> {
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }
}