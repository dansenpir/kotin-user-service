package com.concorde.core.src.domain

import com.concorde.core.src.domain.enums.UserRoleEnum
import java.util.UUID

data class User(
    val id: String = UUID.randomUUID().toString(),
    var login: String,
    var email: String,
    private val password: String,
    var userRoleEnum: UserRoleEnum,
    var claims: List<String> = mutableListOf(),
    var deleted: Boolean = false
) {

    fun getAuthorities(): List<String> {
        return if (this.userRoleEnum == UserRoleEnum.ADMIN) {
            listOf("ROLE_ADMIN", "ROLE_USER")
        } else {
            listOf("ROLE_USER")
        }
    }

    fun isAccountNonExpired(): Boolean {
        return true
    }

    fun isAccountNonLocked(): Boolean {
        return true
    }

    fun isCredentialsNonExpired(): Boolean {
        return true
    }

    fun isEnabled(): Boolean {
        return true
    }
}