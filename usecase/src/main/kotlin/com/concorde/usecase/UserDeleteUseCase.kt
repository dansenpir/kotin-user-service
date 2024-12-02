package com.concorde.usecase

interface UserDeleteUseCase {
    fun delete(id: String): Boolean
}