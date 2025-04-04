package com.concorde.infrastructure.service

import com.concorde.application.gateway.user.UserRegisterGateway
import com.concorde.core.domain.User
import com.concorde.infrastructure.entity.UserEntity
import com.concorde.infrastructure.mapper.UserMapper
import com.concorde.infrastructure.repository.UserEntityRepository
import org.springframework.stereotype.Service

@Service
class UserRegisterGatewayImpl(
    private val userEntityRepository: UserEntityRepository,
    private val userMapper: UserMapper
) : UserRegisterGateway {

    override fun register(user: User): User {
        val userEntity: UserEntity = this.userEntityRepository.save(userMapper.toUserEntity(user))
        return userMapper.toUser(userEntityRepository.save(userEntity))
    }
}