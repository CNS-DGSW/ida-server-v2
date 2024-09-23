package com.daegusw.apply.auth.application.common.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.auth0.jwt.exceptions.TokenExpiredException
import com.auth0.jwt.interfaces.DecodedJWT
import com.auth0.jwt.interfaces.JWTVerifier
import com.daegusw.apply.auth.application.common.dto.Payload
import com.daegusw.apply.auth.application.common.exception.AuthException
import com.daegusw.apply.auth.application.common.property.JwtProperties
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class JwtUtils(
    private val properties: JwtProperties
) {
    private val algorithm: Algorithm by lazy { Algorithm.HMAC256(properties.secret) }
    private val verifier: JWTVerifier by lazy { getVerifier(algorithm) }

    fun createAccessToken(payload: Set<Payload>): String {
        val payloadMap = payload.associate { it.key to it.value }
        return createJwt(payloadMap)
    }

    fun isValidToken(token: String): Boolean {
        return try {
            verifier.verify(token)
            true
        } catch (e: JWTVerificationException) {
            false
        }
    }

    fun verify(jwt: String): DecodedJWT {
        val verifier = getVerifier(algorithm)

        return try {
            verifier.verify(jwt)
        } catch (e: TokenExpiredException) {
            throw AuthException("Expired token")
        } catch (e: JWTVerificationException) {
            throw AuthException("Invalid token")
        }
    }

    fun getTokenFromHeader(headerValue: String?): String? {
        if (headerValue != null && headerValue.startsWith("Bearer ")) {
            return headerValue.replace("Bearer ", "")
        }

        return null
    }

    fun getClaim(token: String, claim: String): String {
        val decodedJWT = verifier.verify(token)
        return decodedJWT.getClaim(claim).asString()
    }

    private fun createJwt(payload: Map<String, String>): String {
        val expiresAt = Instant.now().plusSeconds(properties.expSeconds)

        return JWT.create()
            .withIssuer(properties.issuer)
            .withPayload(payload)
            .withExpiresAt(expiresAt)
            .sign(algorithm)
    }

    private fun getVerifier(algorithm: Algorithm): JWTVerifier {
        return JWT.require(algorithm)
            .withIssuer(properties.issuer)
            .build()
    }
}