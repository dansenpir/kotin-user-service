package com.concorde.application.usecaseimpl

import com.concorde.application.gateway.AuthenticationGateway
import com.concorde.usecase.AuthenticationUseCase

class AuthenticationUseCaseImpl(
    private val authenticationGateway: AuthenticationGateway
) : AuthenticationUseCase {

    override fun authenticate(login: String, password: String): Boolean {
        return authenticationGateway.authenticate(login, password)
    }
}