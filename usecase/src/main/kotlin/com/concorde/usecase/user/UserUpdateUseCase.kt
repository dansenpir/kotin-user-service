package com.concorde.usecase.user

import com.concorde.core.domain.User

interface UserUpdateUseCase {
    fun update(user: User): User
}