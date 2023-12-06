package dev.n7meless.integration.service

import dev.n7meless.TestcontainersApplication
import dev.n7meless.integration.config.ServiceTestConfiguration
import dev.n7meless.integration.container.annotation.EnableDatabaseContainer
import dev.n7meless.service.UserService
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional

@Transactional
@EnableDatabaseContainer
@ContextConfiguration(classes = [ServiceTestConfiguration::class])
@SpringBootTest(classes = [TestcontainersApplication::class], webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserServiceTest {

    @Autowired
    lateinit var userService: UserService

    @ParameterizedTest
    @ValueSource(longs = [1])
    fun `Success - when delete user`(userId: Long) {
        assertDoesNotThrow {
            userService.find(userId)
        }

        userService.delete(userId)

        assertThrows<NotFoundException> {
            userService.find(userId)
        }
    }
}