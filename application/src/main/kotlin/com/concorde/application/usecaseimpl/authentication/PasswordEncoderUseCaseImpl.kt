package com.concorde.application.usecaseimpl.authentication

import com.concorde.application.gateway.authentication.PasswordEncoderGateway
import com.concorde.usecase.authentication.PasswordEncoderUseCase

class PasswordEncoderUseCaseImpl(
    private val passwordEncoderGateway: PasswordEncoderGateway,
) : PasswordEncoderUseCase {
    override fun encode(rawPassword: String): String {
        return passwordEncoderGateway.encode(rawPassword)
    }

    override fun matches(rawPassword: String, encodedPassword: String): Boolean {
        return passwordEncoderGateway.matches(rawPassword, encodedPassword)
    }


}