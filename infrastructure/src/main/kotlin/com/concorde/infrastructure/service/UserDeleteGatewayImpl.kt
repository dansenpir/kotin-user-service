package com.concorde.infrastructure.service

import com.concorde.application.gateway.UserDeleteGateway
import com.concorde.infrastructure.repository.UserEntityRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class UserDeleteGatewayImpl(private val userEntityRepository: UserEntityRepository) : UserDeleteGateway {
    override fun delete(id: String): Boolean {
        return try {
            if (userEntityRepository.existsById(id)) {
                userEntityRepository.deleteById(id)
                true
            } else {
                false
            }
        } catch (exception: EmptyResultDataAccessException) {
            false
        }
    }
}