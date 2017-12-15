package jp.blackawa.distributedmediasite.customerfront.presentation.views.accounts

import jp.blackawa.distributedmediasite.customerfront.presentation.controllers.accounts.ShowController
import jp.blackawa.distributedmediasite.customerfront.presentation.views.layout
import kotlinx.html.h1
import kotlinx.html.p

fun ShowController.render(): String = layout {
    h1 { +"Accounts#show" }
    p { +"find me at ..." }
}
