package dev.n7meless.service.impl.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
internal class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val login: String
)