package jp.blackawa.distributedmediasite.customerfront.presentation.views

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.StringWriter

fun layout(content: BODY.() -> Unit): String = StringWriter().appendHTML().html {
    head {
        meta { charset = "utf-8" }
    }
    body {
        content()
    }
}.toString()