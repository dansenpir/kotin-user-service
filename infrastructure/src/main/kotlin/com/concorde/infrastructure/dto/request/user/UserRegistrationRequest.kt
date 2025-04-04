package com.concorde.infrastructure.dto.request.user

data class UserRegistrationRequest(
    val email: String,
    val login: String,
    val password: String,
    val role: String
)