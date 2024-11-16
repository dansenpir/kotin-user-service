package com.concorde.application.gateway

interface AuthenticationGateway {
    fun authenticate(login: String, password: String): Boolean
}