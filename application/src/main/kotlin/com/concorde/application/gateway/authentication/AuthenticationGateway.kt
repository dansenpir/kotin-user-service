package com.concorde.application.gateway.authentication

interface AuthenticationGateway {
    fun authenticate(login: String, password: String): Boolean
}