package com.concorde.infrastructure.security

import com.concorde.core.domain.AuthenticatedUser
import com.concorde.usecase.authentication.GetUserFromTokenUseCase
import com.concorde.usecase.authentication.ValidateTokenUseCase
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class SecurityFilter(
    private val getUserFromTokenUseCase: GetUserFromTokenUseCase,
    private val validateTokenUseCase: ValidateTokenUseCase
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = recoverToken(request)
        if (token != null) {
            val isValid = validateTokenUseCase.validate(token)
            if (isValid) {
                val userAuthenticated = getUserFromTokenUseCase.getUserFromToken(token)
                val authentication = createAuthenticationToken(userAuthenticated)
                SecurityContextHolder.getContext().authentication = authentication
            }
        }
        filterChain.doFilter(request, response)
    }

    private fun createAuthenticationToken(userAuthenticated: AuthenticatedUser): UsernamePasswordAuthenticationToken {
        val authorities = userAuthenticated.roles.map { SimpleGrantedAuthority(it) }
        return UsernamePasswordAuthenticationToken(userAuthenticated, null, authorities)
    }

    private fun recoverToken(request: HttpServletRequest): String? {
        val authHeader = request.getHeader("Authorization")
        return authHeader?.replace("Bearer ", "")
    }
}