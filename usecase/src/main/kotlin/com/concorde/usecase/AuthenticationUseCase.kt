package com.concorde.usecase

interface AuthenticationUseCase {
    fun authenticate(login: String, password: String): Boolean
}