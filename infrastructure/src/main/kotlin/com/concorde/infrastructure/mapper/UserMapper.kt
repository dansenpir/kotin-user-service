package com.concorde.infrastructure.mapper

import com.concorde.core.domain.User
import com.concorde.core.domain.enums.UserRoleEnum
import com.concorde.infrastructure.dto.request.user.UserRegistrationRequest
import com.concorde.infrastructure.dto.request.user.UserUpdateRequest
import com.concorde.infrastructure.dto.response.UserResponse
import com.concorde.infrastructure.entity.UserEntity
import org.springframework.stereotype.Component
import java.util.Locale

@Component
class UserMapper {
    fun toUser(userEntity: UserEntity): User {
        return User(
            userEntity.id,
            userEntity.login,
            userEntity.email,
            userEntity.password,
            userEntity.role,
            userEntity.claims,
            userEntity.deleted
        )
    }

    fun toUser(request: UserRegistrationRequest): User {
        return User(
            login = request.login,
            email = request.email,
            password = request.password,
            userRoleEnum = UserRoleEnum.valueOf(request.role.uppercase(Locale.getDefault()))
        )
    }

    fun toUser(request: UserUpdateRequest): User {
        return User(
            login = request.login,
            email = request.email,
            password = request.password,
            userRoleEnum = UserRoleEnum.valueOf(request.role.uppercase(Locale.getDefault()))
        )
    }

    fun toUserEntity(user: User): UserEntity {
        return UserEntity(
            user.login,
            user.email,
            user.password,
            user.userRoleEnum.toString()
        )
    }

    fun toUserResponse(user: User): UserResponse {
        return UserResponse(
            user.id ?: "",
            user.login,
            user.email,
            user.userRoleEnum
        )
    }
}