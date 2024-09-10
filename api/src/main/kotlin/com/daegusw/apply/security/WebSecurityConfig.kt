package com.daegusw.apply.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val authenticationProvider: AuthenticationProvider
) {
    companion object {
        private const val ROLE_TEACHER = "TEACHER"
        private const val ROLE_APPLICANT = "APPLICANT"
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .httpBasic().disable()
            .csrf().disable()
            .formLogin().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
            .authorizeHttpRequests()
            .anyRequest().permitAll()

        http
            .addFilterBefore(JwtAuthenticationFilter(authenticationProvider),
                UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }
}