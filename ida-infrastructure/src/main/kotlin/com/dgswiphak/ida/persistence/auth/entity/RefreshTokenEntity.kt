package com.dgswiphak.ida.persistence.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash(value = "refresh_token")
data class RefreshTokenEntity(
    @Id
    val token: String,
    @TimeToLive
    val ttl: Long
)