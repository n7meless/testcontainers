package dev.n7meless.integration.config

import dev.n7meless.service.impl.UserServiceImpl
import dev.n7meless.service.impl.repository.UserRepository
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
internal class ServiceTestConfiguration {

    @Bean
    fun userService(repository: UserRepository) = UserServiceImpl(repository)
}