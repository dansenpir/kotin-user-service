package com.concorde.usecase.authentication

interface AuthenticationUseCase {
    fun authenticate(login: String, password: String): Boolean
}