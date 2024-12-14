package com.concorde.usecase.user

interface UserDeleteUseCase {
    fun delete(id: String): Boolean
}