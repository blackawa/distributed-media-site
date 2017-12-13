package jp.blackawa.distributedmediasite.customerfront.presentation.controllers

import jp.blackawa.distributedmediasite.customerfront.presentation.views.accounts.Show
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Flux

@Controller
class AccountsController {
    @ResponseBody
    @GetMapping("/accounts/{id}")
    @Secured("ROLE_ACCOUNT")
    fun show(): Flux<String> = Flux.just(Show.render())
}