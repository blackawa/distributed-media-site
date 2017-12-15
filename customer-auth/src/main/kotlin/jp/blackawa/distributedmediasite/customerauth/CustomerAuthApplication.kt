package jp.blackawa.distributedmediasite.customerauth

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CustomerAuthApplication

fun main(args: Array<String>) {
    SpringApplication.run(CustomerAuthApplication::class.java, *args)
}
