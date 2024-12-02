package com.concorde.infrastructure.controller

import com.concorde.core.domain.User
import com.concorde.infrastructure.dto.request.authentication.LoginRequest
import com.concorde.infrastructure.dto.request.authentication.ValidateTokenRequest
import com.concorde.infrastructure.dto.response.AuthenticationResponse
import com.concorde.infrastructure.dto.response.BaseResponse
import com.concorde.infrastructure.mapper.UserMapper
import com.concorde.usecase.AuthenticationUseCase
import com.concorde.usecase.GenerateTokenUseCase
import com.concorde.usecase.UserFindByLoginUseCase
import com.concorde.usecase.ValidateTokenUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/authentication")
class AuthenticationController(
    private val authenticationUseCase: AuthenticationUseCase,
    private val generateTokenUseCase: GenerateTokenUseCase,
    private val userFindByLoginUseCase: UserFindByLoginUseCase,
    private val userMapper: UserMapper,
    private val validateTokenUseCase: ValidateTokenUseCase
) {
    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): BaseResponse<AuthenticationResponse> {
        val isAuthenticated: Boolean = authenticationUseCase.authenticate(request.login, request.password)

        if (!isAuthenticated) {
            return BaseResponse.error(
                message = "Authentication failed",
            )
        }

        val user: User = userFindByLoginUseCase.findUserByLogin(request.login)
            ?: return BaseResponse.error(
                message = "User not found",
            )

        val token: String = generateTokenUseCase.generate(user)

        val result = AuthenticationResponse(
            token,
            userMapper.toUserResponse(user)
        )

        return BaseResponse.success(
            result = result,
            message = "Login successful"
        )
    }

    @GetMapping("/validate-token")
    fun validateToken(@RequestBody request: ValidateTokenRequest): BaseResponse<Boolean> {
        val isTokenValid = validateTokenUseCase.validate(request.token)

        return when {
            isTokenValid -> BaseResponse.success(
                message = "Validate token successful",
                result = true
            )

            else -> BaseResponse.error(
                message = "Validate token failed"
            )
        }
    }
}