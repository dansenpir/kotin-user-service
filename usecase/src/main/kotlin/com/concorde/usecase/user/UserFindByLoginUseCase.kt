package com.concorde.usecase.user

import com.concorde.core.domain.User

interface UserFindByLoginUseCase {
    fun findUserByLogin(login: String): User?
}