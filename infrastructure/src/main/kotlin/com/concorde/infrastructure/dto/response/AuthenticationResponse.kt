package com.concorde.infrastructure.dto.response

data class AuthenticationResponse(
    val token: String,
    val user: UserResponse,
)