package com.concorde.application.gateway

import com.concorde.core.domain.User

interface GenerateTokenGateway {
    fun generate(user: User): String
}