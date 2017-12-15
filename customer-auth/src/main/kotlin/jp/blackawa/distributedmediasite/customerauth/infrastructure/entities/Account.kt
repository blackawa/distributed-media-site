package jp.blackawa.distributedmediasite.customerauth.infrastructure.entities

import javax.persistence.*

@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val username: String = "",
    val password: String = ""
)