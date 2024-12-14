package com.concorde.infrastructure.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import com.concorde.application.gateway.authentication.GenerateTokenGateway
import com.concorde.application.gateway.authentication.GetUserFromTokenGateway
import com.concorde.application.gateway.authentication.ValidateTokenGateway
import com.concorde.core.domain.AuthenticatedUser
import com.concorde.core.domain.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Base64

@Service
class JwtTokenService : GenerateTokenGateway, GetUserFromTokenGateway, ValidateTokenGateway {

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

    override fun getUserFromToken(token: String): AuthenticatedUser {
        val payload = decodePayload(token)
        val claims = parseClaims(payload)

        val id = claims["id"] ?: throw IllegalArgumentException("ID not found in token")
        val username = claims["sub"] ?: throw IllegalArgumentException("Username not found in token")
        val roles = claims["roles"]?.split(",") ?: emptyList()

        return AuthenticatedUser(
            id = id,
            username = username,
            roles = roles
        )
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


    private fun decodePayload(token: String): String {
        val parts = token.split(".")
        if (parts.size != 3) throw IllegalArgumentException("Invalid token format")

        val payloadBase64 = parts[1]
        return String(Base64.getUrlDecoder().decode(payloadBase64))
    }

    private fun parseClaims(payload: String): Map<String, String> {
        return payload.trim('{', '}')
            .split(",")
            .map { it.split(":") }
            .associate { (key, value) ->
                key.trim('"') to value.trim().trim('"')
            }
    }

    private fun genExpirationDate() =
        LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"))
}