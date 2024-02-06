package com.dgswiphak.ida.domain.auth.spi.service

interface TokenService {
    fun generateAccessToken(memberId: Long): String

    fun generateRefreshToken(memberId: Long): String

    fun getTokenFromHeader(header: String?): String?

    fun extractIdFromToken(token: String): String
}