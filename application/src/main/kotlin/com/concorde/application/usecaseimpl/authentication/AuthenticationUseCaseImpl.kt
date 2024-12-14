package com.concorde.application.usecaseimpl.authentication

import com.concorde.application.gateway.authentication.AuthenticationGateway
import com.concorde.usecase.authentication.AuthenticationUseCase

class AuthenticationUseCaseImpl(
    private val authenticationGateway: AuthenticationGateway
) : AuthenticationUseCase {

    override fun authenticate(login: String, password: String): Boolean {
        return authenticationGateway.authenticate(login, password)
    }
}