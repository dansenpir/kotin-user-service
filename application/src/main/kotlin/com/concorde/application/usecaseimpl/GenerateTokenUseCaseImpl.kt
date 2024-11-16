package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.GenerateTokenGateway
import com.concorde.core.domain.User
import com.concorde.usecase.GenerateTokenUseCase

class GenerateTokenUseCaseImpl(
    private val generateTokenGateway: GenerateTokenGateway
) : GenerateTokenUseCase {
    override fun generate(user: User): String {
        return generateTokenGateway.generate(user)
    }
}