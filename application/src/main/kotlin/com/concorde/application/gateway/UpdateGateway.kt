package com.concorde.application.gateway

import com.concorde.core.domain.User

interface UpdateGateway {
    fun update(id: String, login: String, email: String): User
}