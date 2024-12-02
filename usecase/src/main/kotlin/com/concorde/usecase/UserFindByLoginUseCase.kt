package com.concorde.usecase

import com.concorde.core.domain.User

interface UserFindByLoginUseCase {
    fun findUserByLogin(login: String): User?
}