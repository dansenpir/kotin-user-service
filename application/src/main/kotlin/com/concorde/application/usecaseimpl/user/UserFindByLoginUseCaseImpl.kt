package com.concorde.application.usecaseimpl.user

import com.concorde.application.gateway.user.UserFindByLoginGateway
import com.concorde.core.domain.User
import com.concorde.usecase.user.UserFindByLoginUseCase

class UserFindByLoginUseCaseImpl(private val findUserFindByLoginGateway: UserFindByLoginGateway) :
    UserFindByLoginUseCase {
    override fun findUserByLogin(login: String): User? {
        return findUserFindByLoginGateway.findUserByLogin(login)
    }
}