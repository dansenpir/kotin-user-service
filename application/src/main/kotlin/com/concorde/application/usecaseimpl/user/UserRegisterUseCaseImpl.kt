package com.concorde.application.usecaseimpl.user

import com.concorde.application.gateway.user.UserRegisterGateway
import com.concorde.core.domain.User
import com.concorde.usecase.authentication.PasswordEncoderUseCase
import com.concorde.usecase.user.UserRegisterUseCase

class UserRegisterUseCaseImpl(
    private val userRegisterGateway: UserRegisterGateway,
    private val passwordEncoderUseCase: PasswordEncoderUseCase
) : UserRegisterUseCase {
    override fun register(user: User): User {

        if (user.login.isBlank() || user.email.isBlank() || user.password.isBlank()) {
            throw IllegalArgumentException("Invalid login or password")
        }

        val encryptedPassword: String = passwordEncoderUseCase.encode(user.password)

        val userWithEncryptedPassword = (user.copy(password = encryptedPassword))

        return userRegisterGateway.register(userWithEncryptedPassword)
    }
}