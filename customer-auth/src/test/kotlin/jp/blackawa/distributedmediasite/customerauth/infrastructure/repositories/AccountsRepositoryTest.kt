package jp.blackawa.distributedmediasite.customerauth.infrastructure.repositories

import jp.blackawa.distributedmediasite.customerauth.infrastructure.entities.Account
import org.assertj.core.api.Assertions.assertThat
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

    @Before
    fun setup() {
        testEntityManager.persist(Account(username = "blackawa", password = "password"))
    }

    @Test
    fun findByUsernameでアカウントが見つかる() {
        val account = accountsRepository.findByUsername("blackawa")
        assertThat(account?.username).isEqualTo("blackawa")
    }

    @Test
    fun findByUsernameでアカウントが見つからない() {
        val account = accountsRepository.findByUsername("whitera")
        assertThat(account).isNull()
    }
}
