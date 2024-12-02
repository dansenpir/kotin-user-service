package com.concorde.infrastructure.entity

import com.concorde.core.domain.enums.UserRoleEnum
import jakarta.persistence.*

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