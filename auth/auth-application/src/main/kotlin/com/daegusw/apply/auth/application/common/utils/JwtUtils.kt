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
    fun createAccessToken(payload: Set<Payload>): String {
        val payloadMap = payload.associate { it.key to it.value }
        println(properties.issuer)
        return createJwt(payloadMap)
    }

    fun verify(jwt: String): DecodedJWT {
        val algorithm = getAlgorithm()
        val verifier = getVerifier(algorithm)

        return try {
            verifier.verify(jwt)
        } catch (e: TokenExpiredException) {
            throw AuthException("Expired token")
        } catch (e: JWTVerificationException) {
            throw AuthException("Invalid token")
        }
    }

    private fun getVerifier(algorithm: Algorithm): JWTVerifier {
        return JWT.require(algorithm)
            .withIssuer(properties.issuer)
            .build()
    }

    private fun createJwt(payload: Map<String, String>): String {
        val algorithm = getAlgorithm()
        val issuer = properties.issuer
        val accessTokenExpirySeconds = properties.expSeconds
        val expiresAt = Instant.now().plusSeconds(accessTokenExpirySeconds)

        return JWT.create()
            .withIssuer(issuer)
            .withPayload(payload)
            .withExpiresAt(expiresAt)
            .sign(algorithm)
    }

    private fun getAlgorithm(): Algorithm {
        return Algorithm.HMAC256(properties.secret)
    }
}