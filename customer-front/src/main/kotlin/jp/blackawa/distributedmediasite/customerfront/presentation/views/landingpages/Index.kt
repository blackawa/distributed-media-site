package jp.blackawa.distributedmediasite.customerfront.presentation.views.landingpages

import jp.blackawa.distributedmediasite.customerfront.presentation.controllers.landingpages.IndexController
import jp.blackawa.distributedmediasite.customerfront.presentation.views.layout
import kotlinx.html.h1

fun IndexController.render() = layout {
    h1 { +"Hello from customer-front" }
}
