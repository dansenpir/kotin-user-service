package com.concorde.usecase

import com.concorde.core.domain.User

interface UserRegisterUseCase {
    fun register(user: User): User
}