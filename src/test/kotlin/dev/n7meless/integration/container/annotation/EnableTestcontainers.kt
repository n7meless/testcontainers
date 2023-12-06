package dev.n7meless.integration.container.annotation

import org.junit.jupiter.api.Tag
import org.springframework.core.annotation.AliasFor
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import java.lang.annotation.Inherited
import kotlin.reflect.KClass

@Inherited
@ContextConfiguration
@Tag("integration-test")
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@TestPropertySource("classpath:application-testcontainers.properties")
annotation class EnableTestcontainers(

    @get:AliasFor(annotation = ContextConfiguration::class, attribute = "classes")
    val classes: Array<KClass<*>> = [],

    @get:AliasFor(annotation = ContextConfiguration::class, attribute = "initializers")
    val initializers: Array<KClass<*>> = []
)