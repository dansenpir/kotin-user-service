package com.concorde.infrastructure.security

import com.concorde.application.gateway.authentication.AuthenticationGateway
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class SpringSecurityAuthenticationGatewayImpl(
    private val authenticationManager: AuthenticationManager
) : AuthenticationGateway {

    override fun authenticate(login: String, password: String): Boolean {
        return try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(login, password))
            true
        } catch (exception: Exception) {
            false
        }
    }
}