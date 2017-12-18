package jp.blackawa.distributedmediasite.clientauth.infrastructure.repositories

import jp.blackawa.distributedmediasite.clientauth.infrastructure.entities.RoleCode
import org.springframework.data.jpa.repository.JpaRepository

interface RoleCodesRepository : JpaRepository<RoleCode, Long>