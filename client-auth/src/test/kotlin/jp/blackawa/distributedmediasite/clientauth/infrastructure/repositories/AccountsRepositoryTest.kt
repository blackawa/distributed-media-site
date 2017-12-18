package jp.blackawa.distributedmediasite.clientauth.infrastructure.repositories

import jp.blackawa.distributedmediasite.clientauth.infrastructure.entities.Account
import jp.blackawa.distributedmediasite.clientauth.infrastructure.entities.RoleCode
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountsRepositoryTest {
    @Autowired
    private lateinit var testEntityManager: TestEntityManager
    @Autowired
    private lateinit var accountsRepository: AccountsRepository
    @Autowired
    private lateinit var roleCodesRepository: RoleCodesRepository

    private var accountId: Long = 0

    @Before
    fun setup() {
        val account = Account(
            email = "blackawa@example.com",
            password = "password",
            roleCodes = setOf(
                RoleCode(id = 1, description = "administrator"),
                RoleCode(id = 2, description = "member")
            )
        )
        testEntityManager.persist(account)
        accountId = account.id
    }

    @Test
    fun 検索後に子要素にアクセスできる() {
        val account = accountsRepository.findById(accountId)
        if (account.isPresent) {
            assertThat(account.get().roleCodes.size).isEqualTo(2)
        } else {
            Fail.fail("could not find account by id[$accountId]")
        }
    }

    @Test
    fun 子要素と一緒にsaveできる() {
        val account = Account(
            email = "test@example.com",
            password = "password",
            roleCodes = roleCodesRepository.findAllById(listOf(1, 2)).toSet()
        )
        accountsRepository.save(account)
        assertThat(accountsRepository.findById(account.id).get().roleCodes.size).isEqualTo(2)
    }
}