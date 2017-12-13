package jp.blackawa.distributedmediasite.customerfront.presentation.views.top

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.io.StringWriter

class Index {
    companion object {
        fun render() = StringWriter().appendHTML().html {
            head {
                meta { charset = "utf-8" }
            }
            body {
                h1 { +"Hello from customer-front" }
            }
        }.toString()
    }
}
