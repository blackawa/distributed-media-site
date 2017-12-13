package jp.blackawa.distributedmediasite.customerfront.presentation.controllers

import jp.blackawa.distributedmediasite.customerfront.presentation.views.top.Index
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Flux

@Controller
class TopController {
    @ResponseBody
    @GetMapping("")
    fun index() = Flux.just(Index.render())
}