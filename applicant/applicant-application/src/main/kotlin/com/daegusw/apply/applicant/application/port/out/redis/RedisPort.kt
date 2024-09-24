package com.daegusw.apply.applicant.application.port.out.redis

interface RedisPort {
    fun save(key: String, value: String, expiration: Long)
    fun delete(key: String)
    fun get(key: String): String?
    fun update(key: String, value: String)
}