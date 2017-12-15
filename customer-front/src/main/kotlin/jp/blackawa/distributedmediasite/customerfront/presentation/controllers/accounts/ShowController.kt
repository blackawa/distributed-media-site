package jp.blackawa.distributedmediasite.customerfront.presentation.controllers.accounts

import jp.blackawa.distributedmediasite.customerfront.presentation.views.accounts.render
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Flux

@Controller("accounts/show")
class ShowController {
    @ResponseBody
    @GetMapping("/accounts/{id}")
    @Secured("ROLE_ACCOUNT")
    fun show(): Flux<String> = Flux.just(render())
}