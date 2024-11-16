package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.ValidateTokenGateway
import com.concorde.usecase.ValidateTokenUseCase

class ValidateTokenUseCaseImpl(
    private val validateTokenGateway: ValidateTokenGateway
) : ValidateTokenUseCase {
    override fun validate(token: String): Boolean {
        return validateTokenGateway.validate(token)
    }
}