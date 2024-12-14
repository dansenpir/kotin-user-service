package com.concorde.application.gateway.authentication

interface ValidateTokenGateway {
    fun validate(token: String): Boolean
}