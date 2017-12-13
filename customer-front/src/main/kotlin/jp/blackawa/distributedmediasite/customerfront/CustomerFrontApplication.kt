package jp.blackawa.distributedmediasite.customerfront

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomerFrontApplication

fun main(args: Array<String>) {
    runApplication<CustomerFrontApplication>(*args)
}
