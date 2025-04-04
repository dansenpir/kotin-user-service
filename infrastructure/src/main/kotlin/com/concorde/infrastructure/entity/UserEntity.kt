package com.concorde.infrastructure.entity

import com.concorde.core.domain.enums.UserRoleEnum
import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn


@Entity(name = "\"user\"")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: String? = "",

    @Column(name = "login", nullable = false)
    val login: String = "",

    @Column(name = "email", nullable = false)
    val email: String = "",

    @Column(name = "password", nullable = false)
    val password: String = "",

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    val role: UserRoleEnum = UserRoleEnum.USER,

    @ElementCollection
    @CollectionTable(name = "user_claims", joinColumns = [JoinColumn(name = "user_id")])
    @Column(name = "claim")
    val claims: List<String>? = mutableListOf(),

    @Column(name = "deleted", nullable = false)
    val deleted: Boolean? = false
)