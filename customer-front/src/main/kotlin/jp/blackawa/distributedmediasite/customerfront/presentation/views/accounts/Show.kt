package jp.blackawa.distributedmediasite.customerfront.presentation.views.accounts

import jp.blackawa.distributedmediasite.customerfront.presentation.controllers.accounts.ShowController
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.StringWriter

fun ShowController.render(): String = StringWriter().appendHTML().html {
    head {
        meta { charset = "utf-8" }
    }
    body {
        h1 { +"Accounts#show" }
        p { +"find me at ..." }
    }
}.toString()
