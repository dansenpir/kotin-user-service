package com.concorde.infrastructure.config

import com.concorde.application.gateway.user.UserDeleteGateway
import com.concorde.application.gateway.user.UserFindByLoginGateway
import com.concorde.application.gateway.user.UserRegisterGateway
import com.concorde.application.gateway.user.UserUpdateGateway
import com.concorde.application.usecaseimpl.user.UserDeleteUseCaseImpl
import com.concorde.application.usecaseimpl.user.UserFindByLoginUseCaseImpl
import com.concorde.application.usecaseimpl.user.UserRegisterUseCaseImpl
import com.concorde.application.usecaseimpl.user.UserUpdateUseCaseImpl
import com.concorde.usecase.authentication.PasswordEncoderUseCase
import com.concorde.usecase.user.UserDeleteUseCase
import com.concorde.usecase.user.UserFindByLoginUseCase
import com.concorde.usecase.user.UserRegisterUseCase
import com.concorde.usecase.user.UserUpdateUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserConfig {
    @Bean
    fun userDeleteUseCase(userDeleteGateway: UserDeleteGateway): UserDeleteUseCase {
        return UserDeleteUseCaseImpl(userDeleteGateway)
    }

    @Bean
    fun userFindByLoginUseCase(userFindByLoginGateway: UserFindByLoginGateway): UserFindByLoginUseCase {
        return UserFindByLoginUseCaseImpl(userFindByLoginGateway)
    }

    @Bean
    fun userRegisterUseCase(
        userRegisterGateway: UserRegisterGateway, passwordEncoderUseCase: PasswordEncoderUseCase
    ): UserRegisterUseCase {
        return UserRegisterUseCaseImpl(userRegisterGateway, passwordEncoderUseCase)
    }

    @Bean
    fun userUpdateUseCase(userUpdateGateway: UserUpdateGateway): UserUpdateUseCase {
        return UserUpdateUseCaseImpl(userUpdateGateway)
    }
}