package com.daegusw.apply.security

import com.daegusw.apply.auth.application.common.utils.JwtUtils
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import java.security.Principal
import java.util.*

@Component
class AuthenticationProvider(
    private val jwtUtils: JwtUtils
) {
    fun findAuthentication(bearerToken: String): Optional<Authentication> {
        return extractAccessToken(bearerToken)
            .filter(jwtUtils::isValidToken)
            .map { token -> createAuthentication(token) }
    }

    private fun createAuthentication(accessToken: String): Authentication {
        val principal = getPrincipal(accessToken)
        val grantedAuthorities = getGrantedAuthorities(accessToken)
        return UsernamePasswordAuthenticationToken(principal, accessToken, grantedAuthorities)
    }

    private fun getPrincipal(accessToken: String): Principal {
        val userId = jwtUtils.getClaim(accessToken, "memberId")
        return Principal { userId }
    }

    private fun getGrantedAuthorities(accessToken: String): List<SimpleGrantedAuthority> {
        val authorities = jwtUtils.getClaim(accessToken, "authorities")
        return authorities.split(",").map { SimpleGrantedAuthority(it) }
    }

    private fun extractAccessToken(bearerToken: String): Optional<String> {
        return if (bearerToken.startsWith("Bearer ")) {
            Optional.of(bearerToken.substring(7))
        } else {
            Optional.empty()
        }
    }
}