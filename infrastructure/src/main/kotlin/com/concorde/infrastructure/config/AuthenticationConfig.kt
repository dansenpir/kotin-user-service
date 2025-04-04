package com.concorde.infrastructure.config

import com.concorde.application.gateway.authentication.AuthenticationGateway
import com.concorde.application.gateway.authentication.GenerateTokenGateway
import com.concorde.application.gateway.authentication.GetUserFromTokenGateway
import com.concorde.application.gateway.authentication.PasswordEncoderGateway
import com.concorde.application.gateway.authentication.ValidateTokenGateway
import com.concorde.application.usecaseimpl.authentication.AuthenticationUseCaseImpl
import com.concorde.application.usecaseimpl.authentication.GenerateTokenUseCaseImpl
import com.concorde.application.usecaseimpl.authentication.GetUserFromTokenUseCaseImpl
import com.concorde.application.usecaseimpl.authentication.PasswordEncoderUseCaseImpl
import com.concorde.application.usecaseimpl.authentication.ValidateTokenUseCaseImpl
import com.concorde.infrastructure.security.SecurityFilter
import com.concorde.usecase.authentication.AuthenticationUseCase
import com.concorde.usecase.authentication.GenerateTokenUseCase
import com.concorde.usecase.authentication.GetUserFromTokenUseCase
import com.concorde.usecase.authentication.PasswordEncoderUseCase
import com.concorde.usecase.authentication.ValidateTokenUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class AuthenticationConfig {

    @Autowired
    private lateinit var getUserFromTokenUseCase: GetUserFromTokenUseCase

    @Autowired
    private lateinit var validateTokenUseCase: ValidateTokenUseCase

    @Bean
    fun securityFilter(): SecurityFilter {
        return SecurityFilter(getUserFromTokenUseCase, validateTokenUseCase)
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors(withDefaults())
            .csrf { csrf -> csrf.disable() }
            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers(HttpMethod.POST, "/authentication/login").permitAll()
                    .requestMatchers(HttpMethod.GET, "/authentication/validate-token").permitAll()
                    .requestMatchers(HttpMethod.POST, "/user/register").permitAll()
                    .requestMatchers(HttpMethod.GET, "/swagger-ui/").permitAll()
                    .anyRequest().authenticated()
            }
            .addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun authenticationUseCase(authenticationGateway: AuthenticationGateway): AuthenticationUseCase {
        return AuthenticationUseCaseImpl(authenticationGateway)
    }

    @Bean
    fun generateTokenUseCase(generateTokenGateway: GenerateTokenGateway): GenerateTokenUseCase {
        return GenerateTokenUseCaseImpl(generateTokenGateway)
    }

    @Bean
    fun getUserFromTokenUseCase(getUserFromTokenGateway: GetUserFromTokenGateway): GetUserFromTokenUseCase {
        return GetUserFromTokenUseCaseImpl(getUserFromTokenGateway)
    }

    @Bean
    fun passwordEncoderUseCase(passwordEncoderGateway: PasswordEncoderGateway): PasswordEncoderUseCase {
        return PasswordEncoderUseCaseImpl(passwordEncoderGateway)
    }

    @Bean
    fun validateTokenUseCase(validateTokenGateway: ValidateTokenGateway): ValidateTokenUseCase {
        return ValidateTokenUseCaseImpl(validateTokenGateway)
    }
}