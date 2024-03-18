package com.dgswiphak.ida.global.filter

import com.dgswiphak.ida.domain.auth.spi.service.TokenService
import com.dgswiphak.ida.global.auth.AuthDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.filter.OncePerRequestFilter


class JwtFilter(
    private val tokenService: TokenService,
    private val authDetailsService: AuthDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest, response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val bearerToken = tokenService.getTokenFromHeader(request.getHeader(HttpHeaders.AUTHORIZATION))

        if (bearerToken != null) {
            val memberId: String = tokenService.extractIdFromToken(bearerToken)
            val userDetails: UserDetails = authDetailsService.loadUserByUsername(memberId)
            val authentication: Authentication = UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.authorities
            )
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }

}