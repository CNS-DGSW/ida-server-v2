package com.daegusw.apply.applicant.redis.adapter.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class RedisProperties (
    @Value("\${spring.redis.host:host}") val host: String,
    @Value("\${spring.redis.port:6379}") val port: Int,
)