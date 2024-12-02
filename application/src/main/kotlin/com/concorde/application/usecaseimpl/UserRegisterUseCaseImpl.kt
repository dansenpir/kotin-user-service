package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.UserRegisterGateway
import com.concorde.core.domain.User
import com.concorde.usecase.PasswordEncoder
import com.concorde.usecase.UserRegisterUseCase

class UserRegisterUseCaseImpl(
    private val userRegisterGateway: UserRegisterGateway,
    private val passwordEncoder: PasswordEncoder
) : UserRegisterUseCase {
    override fun register(user: User): User {

        if (user.login.isBlank() || user.email.isBlank() || user.password.isBlank()) {
            throw IllegalArgumentException("Invalid login or password")
        }

        val encryptedPassword: String = passwordEncoder.encode(user.password)

        val userWithEncryptedPassword = (user.copy(password = encryptedPassword))

        return userRegisterGateway.register(userWithEncryptedPassword)
    }
}