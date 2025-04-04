package com.concorde.usecase.authentication

interface ValidateTokenUseCase {
    fun validate(token: String): Boolean
}