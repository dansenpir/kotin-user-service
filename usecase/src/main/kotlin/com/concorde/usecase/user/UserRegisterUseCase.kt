package com.concorde.usecase.user

import com.concorde.core.domain.User

interface UserRegisterUseCase {
    fun register(user: User): User
}