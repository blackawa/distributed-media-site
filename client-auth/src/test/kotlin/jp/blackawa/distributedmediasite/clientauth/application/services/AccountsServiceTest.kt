package jp.blackawa.distributedmediasite.clientauth.application.services

import jp.blackawa.distributedmediasite.clientauth.infrastructure.entities.RoleCode
import jp.blackawa.distributedmediasite.clientauth.infrastructure.repositories.RoleCodesRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class AccountsServiceTest {
    @Autowired
    private lateinit var accountsService: AccountsService
    @Autowired
    private lateinit var roleCodesRepository: RoleCodesRepository

    @Before
    fun setup() {
        roleCodesRepository.save(RoleCode(id = 1, description = "test1"))
        roleCodesRepository.save(RoleCode(id = 2, description = "test2"))
    }

    @Test
    fun createしたものをfindByIdしてroleCodesが取得できる() {
        val accountId = accountsService.create(email = "test@example.com", password = "p@ssw0rd", roles = arrayOf("1"))
        val account = accountsService.findById(accountId)
        assertThat(accountId).isNotNull()
        assertThat(account?.roleCodes?.size).isEqualTo(1)
    }
}