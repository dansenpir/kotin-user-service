package com.concorde.application.usecaseimpl.user

import com.concorde.application.gateway.user.UserDeleteGateway
import com.concorde.usecase.user.UserDeleteUseCase

class UserDeleteUseCaseImpl(
    private val userDeleteGateway: UserDeleteGateway
) : UserDeleteUseCase {
    override fun delete(id: String): Boolean {
        return userDeleteGateway.delete(id)
    }
}