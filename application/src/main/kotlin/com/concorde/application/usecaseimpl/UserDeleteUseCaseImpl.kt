package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.UserDeleteGateway
import com.concorde.usecase.UserDeleteUseCase

class UserDeleteUseCaseImpl(
    private val userDeleteGateway: UserDeleteGateway
) : UserDeleteUseCase {
    override fun delete(id: String): Boolean {
        return userDeleteGateway.delete(id)
    }
}