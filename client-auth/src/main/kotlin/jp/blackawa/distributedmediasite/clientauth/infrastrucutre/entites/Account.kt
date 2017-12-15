package jp.blackawa.distributedmediasite.clientauth.infrastrucutre.entites

import javax.persistence.*

@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val email: String = "",
    val password: String = ""
)