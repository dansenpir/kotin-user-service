package com.concorde.application.gateway

interface ValidateTokenGateway {
    fun validate(token: String): Boolean
}