package com.concorde.application.usecaseimpl.user

import com.concorde.application.gateway.user.UserUpdateGateway
import com.concorde.core.domain.User
import com.concorde.usecase.user.UserUpdateUseCase

class UserUpdateUseCaseImpl(
    private val userUpdateGateway: UserUpdateGateway
) : UserUpdateUseCase {
    override fun update(user: User): User {
        return userUpdateGateway.update(user)
    }
}