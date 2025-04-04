package com.concorde.application.gateway.authentication

import com.concorde.core.domain.AuthenticatedUser

interface GetUserFromTokenGateway {
    fun getUserFromToken(token: String): AuthenticatedUser
}