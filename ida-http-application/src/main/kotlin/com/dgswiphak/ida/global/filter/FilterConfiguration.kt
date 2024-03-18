package com.dgswiphak.ida.global.filter

import com.dgswiphak.ida.domain.auth.spi.service.TokenService
import com.dgswiphak.ida.global.auth.AuthDetailsService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component

@Component
class FilterConfiguration(
    private val tokenService: TokenService,
    private val authDetailsService: AuthDetailsService,
    private val objectMapper: ObjectMapper
) : SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> {
    override fun init(builder: HttpSecurity?) {}

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(
            JwtFilter(tokenService, authDetailsService),
            UsernamePasswordAuthenticationFilter::class.java
        )
        builder.addFilterBefore(ExceptionFilter(objectMapper), JwtFilter::class.java)
    }
}