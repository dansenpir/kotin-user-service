package br.com.concorde.core.exception

class InternalServerErrorException(message: String, val code: String) : Exception(message)