package com.concorde.usecase

import com.concorde.core.domain.User
import com.concorde.core.domain.enums.UserRoleEnum

interface RegisterUseCase {
    fun register(login: String, email: String, password: String, role: UserRoleEnum): User
}