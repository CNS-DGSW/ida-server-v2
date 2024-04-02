package com.dgswiphak.ida.persistence.auth.service

import com.dgswiphak.ida.common.config.property.JwtProperties
import com.dgswiphak.ida.domain.auth.exception.ExpiredTokenException
import com.dgswiphak.ida.domain.auth.exception.InvalidTokenException
import com.dgswiphak.ida.domain.auth.model.TokenType
import com.dgswiphak.ida.domain.auth.spi.service.TokenService
import com.dgswiphak.ida.persistence.auth.entity.RefreshTokenEntity
import com.dgswiphak.ida.persistence.auth.repository.RefreshTokenRepository
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.lang.Exception
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.*

@Service
class TokenServiceImpl(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProperties: JwtProperties
) : TokenService {
    override fun generateAccessToken(memberId: Long): String {
        return generateToken(memberId, TokenType.ACCESS_TOKEN, jwtProperties.accessExpirationMillis)
    }

    override fun generateRefreshToken(memberId: Long): String {
        val refreshToken = generateToken(memberId, TokenType.REFRESH_TOKEN, jwtProperties.refreshExpirationMillis)
        refreshTokenRepository.save(
            RefreshTokenEntity(
                refreshToken,
                jwtProperties.refreshExpirationMillis
            )
        )
        return refreshToken
    }

    override fun getTokenFromHeader(header: String?): String? {
        if(header != null && header.startsWith("Bearer ")) {
            return header.replace("Bearer ", "")
        }

        return null
    }

    override fun extractIdFromToken(token: String): String {
            return extractAllClaims(token)["memberId"].toString()
    }

    private fun generateToken(memberId: Long, tokenType: TokenType, time: Long): String {
        val claims = Jwts.claims().apply {
            this["memberId"] = memberId
            this["type"] = tokenType.identity
        }

        val now = Date()

        val secretKey = when(tokenType) {
            TokenType.ACCESS_TOKEN -> jwtProperties.accessTokenSecretKey
            TokenType.REFRESH_TOKEN -> jwtProperties.refreshTokenSecretKey
        }

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + time))
            .signWith(getSigningKey(secretKey), SignatureAlgorithm.HS256)
            .compact()
    }

    private fun extractAllClaims(token: String): Claims {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(getSigningKey(jwtProperties.accessTokenSecretKey))
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredTokenException) {
            println(e.cause)
            throw ExpiredTokenException
        } catch (e: Exception) {
            throw InvalidTokenException
        }
    }

    private fun getSigningKey(secretKey: String): Key {
        val keyBytes: ByteArray = secretKey.toByteArray(StandardCharsets.UTF_8)
        return Keys.hmacShaKeyFor(keyBytes)
    }

}