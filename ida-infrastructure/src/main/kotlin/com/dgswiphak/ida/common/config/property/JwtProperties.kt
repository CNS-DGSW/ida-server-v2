package com.dgswiphak.ida.common.config.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
class JwtProperties (
    val accessTokenSecretKey: String,
    val refreshTokenSecretKey: String,
    val accessExpirationMillis: Long,
    val refreshExpirationMillis: Long
)