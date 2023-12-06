package dev.n7meless.service

import dev.n7meless.service.model.User
import org.springframework.stereotype.Service

@Service
interface UserService {

    fun find(id: Long): User

    fun delete(id: Long)
}