package com.concorde.infrastructure.service

import com.concorde.application.gateway.user.UserUpdateGateway
import com.concorde.core.domain.User
import com.concorde.core.exception.NotFoundException
import com.concorde.infrastructure.entity.UserEntity
import com.concorde.infrastructure.mapper.UserMapper
import com.concorde.infrastructure.repository.UserEntityRepository
import org.springframework.stereotype.Service

@Service
class UserUpdateGatewayImpl(
    private val userEntityRepository: UserEntityRepository,
    private val userMapper: UserMapper
) : UserUpdateGateway {

    override fun update(user: User): User {
        user.id?.let { id ->
            userEntityRepository.findById(id).orElseThrow {
                NotFoundException("User not found with id: $id")
            }
        } ?: throw NotFoundException("User ID must not be null")

        val userEntity: UserEntity = userMapper.toUserEntity(user)
        val userUpdated = userEntityRepository.save(userEntity)
        return userMapper.toUser(userUpdated)
    }
}