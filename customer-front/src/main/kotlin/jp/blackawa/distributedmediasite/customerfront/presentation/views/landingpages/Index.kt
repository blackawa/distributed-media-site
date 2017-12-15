package jp.blackawa.distributedmediasite.customerfront.presentation.views.landingpages

import jp.blackawa.distributedmediasite.customerfront.presentation.controllers.landingpages.IndexController
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.StringWriter

fun IndexController.render() = StringWriter().appendHTML().html {
    head {
        meta { charset = "utf-8" }
    }
    body {
        h1 { +"Hello from customer-front" }
    }
}.toString()

