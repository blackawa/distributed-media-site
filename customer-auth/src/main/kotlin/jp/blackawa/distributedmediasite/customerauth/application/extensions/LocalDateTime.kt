package jp.blackawa.distributedmediasite.`customer-auth`.application.extensions

import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

fun LocalDateTime.toDate(): Date = Date.from(this.atZone(ZoneId.systemDefault()).toInstant())
