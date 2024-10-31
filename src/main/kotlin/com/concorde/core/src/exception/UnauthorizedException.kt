package br.com.concorde.core.exception

class UnauthorizedException(message: String, val code: String) : Exception(message)