package dev.n7meless.integration.container.annotation

import org.junit.jupiter.api.Tag
import org.springframework.test.context.TestPropertySource
import java.lang.annotation.Inherited

@Inherited
@Tag("integration-test")
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@TestPropertySource("classpath:application-testcontainers.properties")
annotation class EnableTestcontainers