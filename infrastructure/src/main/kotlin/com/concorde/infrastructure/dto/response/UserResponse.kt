package com.concorde.infrastructure.dto.response

import com.concorde.core.domain.enums.UserRoleEnum

data class UserResponse(
    val id: String,
    val email: String,
    val login: String,
    val role: UserRoleEnum,
)