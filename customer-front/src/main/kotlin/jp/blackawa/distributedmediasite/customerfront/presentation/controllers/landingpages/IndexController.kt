package jp.blackawa.distributedmediasite.customerfront.presentation.controllers.landingpages

import jp.blackawa.distributedmediasite.customerfront.presentation.views.landingpages.render
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Flux

@Controller("landingpages/index")
class IndexController {
    @ResponseBody
    @GetMapping("")
    fun index(): Flux<String> = Flux.just(render())
}