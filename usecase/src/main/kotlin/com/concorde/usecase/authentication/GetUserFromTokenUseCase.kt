package com.concorde.usecase.authentication

import com.concorde.core.domain.AuthenticatedUser

interface GetUserFromTokenUseCase {
    fun getUserFromToken(token: String): AuthenticatedUser
}