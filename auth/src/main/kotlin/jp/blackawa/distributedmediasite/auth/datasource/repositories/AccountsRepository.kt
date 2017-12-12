package jp.blackawa.distributedmediasite.auth.datasource.repositories

import jp.blackawa.distributedmediasite.auth.datasource.entities.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface AccountsRepository : JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
    fun findByUsername(username: String): Account
}