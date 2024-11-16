package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.RegisterGateway
import com.concorde.core.domain.User
import com.concorde.core.domain.enums.UserRoleEnum
import com.concorde.usecase.RegisterUseCase

class RegisterUseCaseImpl(
    private val registerGateway: RegisterGateway
) : RegisterUseCase {
    override fun register(
        login: String,
        email: String,
        password: String,
        role: UserRoleEnum
    ): User {
        return registerGateway.register(login, email, password, role)
    }
}