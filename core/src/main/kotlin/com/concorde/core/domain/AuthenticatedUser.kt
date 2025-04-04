package com.concorde.core.domain

data class AuthenticatedUser(
    val id: String,
    val username: String,
    val roles: List<String>
)