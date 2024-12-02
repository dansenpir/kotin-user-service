package com.concorde.usecase

interface PasswordEncoder {
    fun encode(rawPassword: String): String

    fun matches(rawPassword: String, encodedPassword: String): Boolean
}