package com.concorde.usecase

import com.concorde.core.domain.User

interface UserUpdateUseCase {
    fun update(user: User): User
}