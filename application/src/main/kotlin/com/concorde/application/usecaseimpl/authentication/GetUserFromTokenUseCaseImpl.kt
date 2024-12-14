package com.concorde.application.usecaseimpl.authentication

import com.concorde.application.gateway.authentication.GetUserFromTokenGateway
import com.concorde.core.domain.AuthenticatedUser
import com.concorde.usecase.authentication.GetUserFromTokenUseCase

class GetUserFromTokenUseCaseImpl(private val getUserFromTokenGateway: GetUserFromTokenGateway) :
    GetUserFromTokenUseCase {
    override fun getUserFromToken(token: String): AuthenticatedUser {
        return getUserFromTokenGateway.getUserFromToken(token)
    }
}