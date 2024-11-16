package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.UpdateGateway
import com.concorde.core.domain.User
import com.concorde.usecase.UpdateUseCase

class UpdateUseCaseImpl(
    private val updateGateway: UpdateGateway
) : UpdateUseCase {
    override fun update(id: String, login: String, email: String): User {
        return updateGateway.update(id, login, email)
    }
}