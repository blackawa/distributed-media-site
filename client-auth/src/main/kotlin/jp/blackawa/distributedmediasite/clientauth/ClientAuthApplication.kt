package jp.blackawa.distributedmediasite.clientauth

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ClientAuthApplication

fun main(args: Array<String>) {
    SpringApplication.run(ClientAuthApplication::class.java, *args)
}
