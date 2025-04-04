package com.concorde.application.usecaseimpl.authentication

import com.concorde.application.gateway.authentication.GenerateTokenGateway
import com.concorde.core.domain.User
import com.concorde.usecase.authentication.GenerateTokenUseCase

class GenerateTokenUseCaseImpl(
    private val generateTokenGateway: GenerateTokenGateway
) : GenerateTokenUseCase {
    override fun generate(user: User): String {
        return generateTokenGateway.generate(user)
    }
}