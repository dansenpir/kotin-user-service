package com.concorde.application.gateway.authentication

interface PasswordEncoderGateway {
    fun encode(rawPassword: String): String

    fun matches(rawPassword: String, encodedPassword: String): Boolean
}