package com.concorde.usecase.authentication

import com.concorde.core.domain.User

interface GenerateTokenUseCase {
    fun generate(user: User): String
}