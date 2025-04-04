package com.concorde.application.gateway.user

interface UserDeleteGateway {
    fun delete(id: String): Boolean
}