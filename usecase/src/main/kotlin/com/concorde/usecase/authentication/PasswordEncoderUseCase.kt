package com.concorde.usecase.authentication

interface PasswordEncoderUseCase {
    fun encode(rawPassword: String): String

    fun matches(rawPassword: String, encodedPassword: String): Boolean
}