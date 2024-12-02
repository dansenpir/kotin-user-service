package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.UserFindByLoginGateway
import com.concorde.core.domain.User
import com.concorde.usecase.UserFindByLoginUseCase

class UserFindByLoginUseCaseImpl(private val findUserFindByLoginGateway: UserFindByLoginGateway) :
    UserFindByLoginUseCase {
    override fun findUserByLogin(login: String): User? {
        return findUserFindByLoginGateway.findUserByLogin(login)
    }
}