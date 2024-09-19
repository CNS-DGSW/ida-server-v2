package com.daegusw.apply.auth.application.common.property

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class JwtProperties(
    @Value("\${jwt.issuer:issuer}") val issuer: String,
    @Value("\${jwt.secret:secret}") val secret: String,
    @Value("\${jwt.exp-seconds:1800}") val expSeconds: Long
)