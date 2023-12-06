package dev.n7meless.service.impl

import dev.n7meless.service.UserService
import dev.n7meless.service.impl.repository.UserRepository
import dev.n7meless.service.model.User
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
internal class UserServiceImpl(
    private val repo: UserRepository
) : UserService {

    override fun find(id: Long): User =
        repo.findById(id).map { User(it.id, it.login) }.orElseThrow { NotFoundException() }

    override fun delete(id: Long) = repo.deleteById(id)
}