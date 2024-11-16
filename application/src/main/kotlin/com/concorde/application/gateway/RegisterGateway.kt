package com.concorde.application.gateway

import com.concorde.core.domain.User
import com.concorde.core.domain.enums.UserRoleEnum

interface RegisterGateway {
    fun register(login: String, email: String, password: String, role: UserRoleEnum): User
}