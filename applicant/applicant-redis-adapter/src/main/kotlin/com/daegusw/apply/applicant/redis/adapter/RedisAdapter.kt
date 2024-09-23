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
        try{
            redisTemplate.opsForValue().set(key, value, Duration.ofMinutes(expiration))

        }catch(e:Exception){
            throw e
        }
    }

    override fun delete(key: String) {
        try{
            redisTemplate.delete(key)
        }catch(e:Exception){
            throw e
        }
    }

    override fun get(key: String): String? {
        try {
            return redisTemplate.opsForValue().get(key)
        }catch(e:Exception){
            throw e
        }
    }

}