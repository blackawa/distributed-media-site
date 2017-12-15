package jp.blackawa.distributedmediasite.customerauth.infrastructure.repositories

import jp.blackawa.distributedmediasite.customerauth.infrastructure.entities.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface AccountsRepository : JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
    fun findByUsername(username: String): Account?
}