package com.concorde.application.gateway

interface UserDeleteGateway {
    fun delete(id: String): Boolean
}