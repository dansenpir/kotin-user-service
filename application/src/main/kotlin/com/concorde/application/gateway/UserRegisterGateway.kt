package com.concorde.application.gateway

import com.concorde.core.domain.User

interface UserRegisterGateway {
    fun register(user: User): User
}