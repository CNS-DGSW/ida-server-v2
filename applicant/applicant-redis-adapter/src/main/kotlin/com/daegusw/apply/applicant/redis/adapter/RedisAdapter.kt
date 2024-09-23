package com.daegusw.apply.applicant.redis.adapter

import com.daegusw.apply.applicant.application.port.out.redis.RedisPort
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.time.Duration

@Component
class RedisAdapter(
    private val redisTemplate: RedisTemplate<String, String>,
) : RedisPort {
    override fun save(key: String, value: String, expiration: Long) {
        redisTemplate.opsForValue().set(key, value, Duration.ofMinutes(expiration))
    }

    override fun delete(key: String) {
        redisTemplate.delete(key)
    }

    override fun get(key: String): String? {
        return redisTemplate.opsForValue().get(key)
    }

}