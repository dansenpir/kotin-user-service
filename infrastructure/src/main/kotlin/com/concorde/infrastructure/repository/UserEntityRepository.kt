package com.concorde.infrastructure.repository

import com.concorde.infrastructure.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserEntityRepository : JpaRepository<UserEntity, String> {
    fun findByLogin(login: String): Optional<UserEntity>
}