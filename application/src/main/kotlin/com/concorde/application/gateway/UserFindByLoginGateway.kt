package com.concorde.application.gateway

import com.concorde.core.domain.User

interface UserFindByLoginGateway {
    fun findUserByLogin(login: String): User?
}