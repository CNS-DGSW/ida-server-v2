package com.daegusw.apply.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter(
    private val authenticationProvider: AuthenticationProvider
) : OncePerRequestFilter() {
    companion object {
        const val AUTHORIZATION: String = "Authorization"
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val bearerToken = request.getHeader(AUTHORIZATION)
        val authentication: Optional<Authentication> = authenticationProvider
            .findAuthentication(bearerToken)
        authentication.ifPresent { auth -> SecurityContextHolder.getContext().authentication = auth }

        filterChain.doFilter(request, response)
    }
}