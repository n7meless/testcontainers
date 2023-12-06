package dev.n7meless.integration.container

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.lifecycle.Startables

internal class DatabaseContainerInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        TestPropertyValues.of(
            "spring.datasource.url=${POSTGRESQL_CONTAINER.jdbcUrl}",
            "spring.datasource.username=${POSTGRESQL_CONTAINER.username}",
            "spring.datasource.password=${POSTGRESQL_CONTAINER.password}"
        ).applyTo(applicationContext.environment)
    }

    companion object {
        private const val PG_VERSION = "16-alpine"
        private const val DATABASE = "litcorp_db_test"

        private val POSTGRESQL_CONTAINER = PostgreSQLContainer<Nothing>("postgres:$PG_VERSION")
            .apply {
                withDatabaseName(DATABASE)
                withUsername("postgres")
                withPassword("postgres")
                withReuse(true)
            }

        init {
            Startables.deepStart(POSTGRESQL_CONTAINER).join()
        }
    }
}


