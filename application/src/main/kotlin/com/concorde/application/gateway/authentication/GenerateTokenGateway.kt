package com.concorde.application.gateway.authentication

import com.concorde.core.domain.User

interface GenerateTokenGateway {
    fun generate(user: User): String
}