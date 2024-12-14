package com.concorde.application.usecaseimpl.authentication

import com.concorde.application.gateway.authentication.ValidateTokenGateway
import com.concorde.usecase.authentication.ValidateTokenUseCase

class ValidateTokenUseCaseImpl(
    private val validateTokenGateway: ValidateTokenGateway
) : ValidateTokenUseCase {
    override fun validate(token: String): Boolean {
        return validateTokenGateway.validate(token)
    }
}