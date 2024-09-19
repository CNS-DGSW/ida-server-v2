package com.daegusw.apply.security

import com.daegusw.apply.auth.application.common.exception.AuthException
import com.daegusw.apply.auth.application.common.utils.JwtUtils
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthenticationFilter(
    private val jwtUtils: JwtUtils,
    private val detailService: AuthDetailService
) : OncePerRequestFilter() {

    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val bearerToken = jwtUtils.getTokenFromHeader(request.getHeader(HttpHeaders.AUTHORIZATION))
            if (bearerToken != null) {
                val id = jwtUtils.getClaim(bearerToken, "memberId")
                val userDetails = detailService.loadUserByUsername(id)
                val authentication = UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.authorities
                )
                SecurityContextHolder.getContext().authentication = authentication
            }
        } catch (e: AuthException) {
            filterException(e, response)
        }
        filterChain.doFilter(request, response)
    }

    @Throws(IOException::class)
    private fun filterException(exception: AuthException, response: HttpServletResponse) {
        response.status = HttpStatus.FORBIDDEN.value()
        response.characterEncoding = "UTF-8"
        response.contentType = "application/json"
        response.writer.write(exception.message!!)
    }
}