package com.dgswiphak.ida.domain.auth.model

data class RefreshToken(
    val token: String,
    val ttl: Long
)