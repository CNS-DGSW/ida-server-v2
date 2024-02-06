package com.dgswiphak.ida.global.filter

import com.dgswiphak.ida.domain.auth.spi.service.TokenService
import com.dgswiphak.ida.global.auth.AuthDetailsService
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.nio.charset.StandardCharsets


@Component
class JwtFilter(
    private val tokenService: TokenService,
    private val authDetailsService: AuthDetailsService
) : OncePerRequestFilter() {
    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(
        request: HttpServletRequest, response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val bearerToken = tokenService.getTokenFromHeader(request.getHeader(HttpHeaders.AUTHORIZATION))
            if (bearerToken != null) {
                val memberId: String = tokenService.extractIdFromToken(bearerToken)
                val userDetails: UserDetails = authDetailsService.loadUserByUsername(memberId)
                val authentication: Authentication = UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.authorities
                )
                SecurityContextHolder.getContext().authentication = authentication
            }
        } catch (e: RuntimeException) {
            filterException(e, response)
        }
        filterChain.doFilter(request, response)
    }

    //TODO RuntimeException Handling
    @Throws(IOException::class)
    private fun filterException(exception: RuntimeException, response: HttpServletResponse) {
        response.status = HttpStatus.BAD_REQUEST.value()
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(exception.message)
    }
}