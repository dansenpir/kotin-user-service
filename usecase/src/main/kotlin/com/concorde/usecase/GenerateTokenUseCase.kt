package com.concorde.usecase

import com.concorde.core.domain.User

interface GenerateTokenUseCase {
    fun generate(user: User): String
}