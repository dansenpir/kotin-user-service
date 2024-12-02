package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.UserUpdateGateway
import com.concorde.core.domain.User
import com.concorde.usecase.UserUpdateUseCase

class UserUpdateUseCaseImpl(
    private val userUpdateGateway: UserUpdateGateway
) : UserUpdateUseCase {
    override fun update(user: User): User {
        return userUpdateGateway.update(user)
    }
}