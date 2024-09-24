package com.daegusw.apply.api.security

import com.daegusw.apply.api.security.exception.SecurityErrorCode
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter,
    private val responseSender: ErrorResponseSender
) {
    companion object {
        private const val ROLE_TEACHER = "TEACHER"
        private const val ROLE_APPLICANT = "APPLICANT"
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { it.disable() }
            .formLogin { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .cors(Customizer.withDefaults())

        http
            .authorizeHttpRequests()
            .anyRequest().permitAll()

        http
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

            .exceptionHandling {
                it.authenticationEntryPoint { _, response, _ ->
                    responseSender.send(response, SecurityErrorCode.NOT_FOUND)
                }
                it.accessDeniedHandler { _, response, _ ->
                    responseSender.send(response, SecurityErrorCode.FORBIDDEN_REQUEST)
                }
            }
        return http.build()
    }
}
