package com.concorde.application.gateway.user

import com.concorde.core.domain.User

interface UserFindByLoginGateway {
    fun findUserByLogin(login: String): User?
}