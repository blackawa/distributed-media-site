package jp.blackawa.distributedmediasite.clientauth.infrastructure.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "role_codes")
data class RoleCode(
    @Id
    val id: Long = 0,
    val description: String = "",
    val enabledAt: LocalDateTime? = null,
    val disabledAt: LocalDateTime? = null,
    @ManyToMany(mappedBy = "roleCodes", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    val accounts: Set<Account> = setOf()
)