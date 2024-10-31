package br.com.concorde.core.exception

class NotFoundException(message: String, val code: String) : Exception(message)