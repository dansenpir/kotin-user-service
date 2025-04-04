package com.concorde.infrastructure.service

import com.concorde.application.gateway.user.UserFindByLoginGateway
import com.concorde.core.domain.User
import com.concorde.infrastructure.mapper.UserMapper
import com.concorde.infrastructure.repository.UserEntityRepository
import org.springframework.stereotype.Service

@Service
class UserFindByLoginGatewayImpl(
    private val userEntityRepository: UserEntityRepository,
    private val userMapper: UserMapper
) : UserFindByLoginGateway {
    override fun findUserByLogin(login: String): User? {
        return userMapper.toUser(userEntityRepository.findByLogin(login).orElse(null))
    }
}