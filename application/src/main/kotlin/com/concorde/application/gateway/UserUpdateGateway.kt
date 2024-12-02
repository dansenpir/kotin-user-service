package com.concorde.application.gateway

import com.concorde.core.domain.User

interface UserUpdateGateway {
    fun update(user: User): User
}