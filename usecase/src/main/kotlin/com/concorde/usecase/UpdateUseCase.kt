package com.concorde.usecase

import com.concorde.core.domain.User

interface UpdateUseCase {
    fun update(id: String, login: String, email: String): User
}