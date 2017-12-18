package jp.blackawa.distributedmediasite.clientauth.infrastructure.repositories

import jp.blackawa.distributedmediasite.clientauth.infrastructure.entities.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountsRepository : JpaRepository<Account, Long>