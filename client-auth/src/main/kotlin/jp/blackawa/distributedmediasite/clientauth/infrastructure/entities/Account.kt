package jp.blackawa.distributedmediasite.clientauth.infrastructure.entities

import javax.persistence.*

@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val email: String = "",
    val password: String = "",
    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "accounts_role_codes",
        joinColumns = [JoinColumn(name = "account_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_code_id", referencedColumnName = "id")]
    )
    var roleCodes: Set<RoleCode> = setOf()
)