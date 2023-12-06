package dev.n7meless.integration.container.annotation

import dev.n7meless.integration.container.DatabaseContainerInitializer
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlMergeMode
import org.springframework.test.context.jdbc.SqlMergeMode.MergeMode

@EnableTestcontainers
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@SqlMergeMode(MergeMode.MERGE)
@Sql(scripts = ["classpath:sql/init-database.sql"])
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(initializers = [DatabaseContainerInitializer::class])
annotation class EnableDatabaseContainer
