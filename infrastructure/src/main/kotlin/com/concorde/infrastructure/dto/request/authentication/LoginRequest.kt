package com.concorde.infrastructure.dto.request.authentication

data class LoginRequest(
    val login: String,
    val password: String,
)