package jp.blackawa.distributedmediasite.clientauth.application.extensions

import jp.blackawa.distributedmediasite.clientauth.presentation.responses.BadRequest
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError

fun BindingResult.badRequests(): List<BadRequest> = allErrors
    .groupBy { (it as FieldError).field }
    .map { (field, errors) ->
        BadRequest(
            key = field,
            value = (errors.first() as FieldError).rejectedValue as String,
            messages = errors.map { it.defaultMessage }
        )
    }