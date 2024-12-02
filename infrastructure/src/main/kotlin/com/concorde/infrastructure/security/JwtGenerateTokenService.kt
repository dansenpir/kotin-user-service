package com.concorde.infrastructure.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import com.concorde.application.gateway.GenerateTokenGateway
import com.concorde.application.gateway.ValidateTokenGateway
import com.concorde.core.domain.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class JwtGenerateTokenService : GenerateTokenGateway, ValidateTokenGateway {

    @Value("\${api.security.token.secret}")
    private lateinit var secret: String

    override fun generate(user: User): String {
        try {
            val algorithm = Algorithm.HMAC256(secret)
            val userClaims = user.claims?.toTypedArray() ?: arrayOf("a")

            return JWT.create()
                .withIssuer("scheduler")
                .withSubject(user.login)
                .withExpiresAt(genExpirationDate())
                .withArrayClaim("user_claims", userClaims)
                .sign(algorithm)
        } catch (exception: JWTCreationException) {
            throw RuntimeException("Error while generating token", exception)
        }
    }

    override fun validate(token: String): Boolean {
        return try {
            val algorithm = Algorithm.HMAC256(secret)
            JWT.require(algorithm)
                .withIssuer("scheduler")
                .build()
                .verify(token)
                .subject
            
            true
        } catch (exception: JWTVerificationException) {
            false
        }
    }

    private fun genExpirationDate() =
        LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"))
}