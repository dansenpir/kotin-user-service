package com.concorde.infrastructure.controller

import com.concorde.core.domain.User
import com.concorde.infrastructure.dto.request.user.UserDeleteRequest
import com.concorde.infrastructure.dto.request.user.UserRegistrationRequest
import com.concorde.infrastructure.dto.request.user.UserUpdateRequest
import com.concorde.infrastructure.dto.response.BaseResponse
import com.concorde.infrastructure.dto.response.UserResponse
import com.concorde.infrastructure.mapper.UserMapper
import com.concorde.usecase.user.UserDeleteUseCase
import com.concorde.usecase.user.UserRegisterUseCase
import com.concorde.usecase.user.UserUpdateUseCase
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/user")
class UserController(
    private val userDeleteUseCase: UserDeleteUseCase,
    private val userRegisterUseCase: UserRegisterUseCase,
    private val userUpdateUseCase: UserUpdateUseCase,
    private val userMapper: UserMapper
) {
    @PostMapping
    fun register(@RequestBody request: UserRegistrationRequest): BaseResponse<UserResponse> {
        val registeredUser: User = userRegisterUseCase.register(userMapper.toUser(request))

        return BaseResponse.success(
            message = "User created successfully",
            result = userMapper.toUserResponse(registeredUser)
        )
    }

    @PutMapping
    fun update(@RequestBody request: UserUpdateRequest): BaseResponse<UserResponse> {
        val updatedUser: User = userUpdateUseCase.update(userMapper.toUser(request))

        return BaseResponse.success(
            message = "User updated successfully",
            result = userMapper.toUserResponse(updatedUser)
        )
    }

    @DeleteMapping
    fun delete(@RequestBody request: UserDeleteRequest): BaseResponse<Boolean> {
        val isDeletedUser: Boolean = userDeleteUseCase.delete(request.id)

        return when {
            isDeletedUser -> BaseResponse.success(
                message = "User deleted successfully",
                result = true
            )

            else -> BaseResponse.error(
                message = "User not found or deletion failed"
            )
        }
    }
}