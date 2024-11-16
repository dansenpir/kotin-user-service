package com.concorde.usecase

interface ValidateTokenUseCase {
    fun validate(token: String): Boolean
}