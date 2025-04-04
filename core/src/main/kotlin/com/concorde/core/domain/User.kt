package com.concorde.core.domain

import com.concorde.core.domain.enums.UserRoleEnum

data class User(
    val id: String? = null,
    val login: String,
    val email: String,
    val password: String,
    val userRoleEnum: UserRoleEnum,
    val claims: List<String>? = mutableListOf(),
    val deleted: Boolean? = false
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