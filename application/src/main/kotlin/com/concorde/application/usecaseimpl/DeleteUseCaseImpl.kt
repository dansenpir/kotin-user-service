package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.DeleteGateway
import com.concorde.usecase.DeleteUseCase

class DeleteUseCaseImpl(
    private val deleteGateway: DeleteGateway
) : DeleteUseCase {
    override fun delete(id: String): Boolean {
        return deleteGateway.delete(id)
    }
}