package com.daegusw.apply.applicant.application.service

import com.daegusw.apply.applicant.application.port.`in`.web.SmtpUseCase
import com.daegusw.apply.applicant.application.port.out.redis.RedisPort
import com.daegusw.apply.applicant.application.port.out.smtp.SmtpPort
import org.springframework.stereotype.Service

@Service
class SmtpService(
    private val stmpPort: SmtpPort,
    private val redisPort: RedisPort,
) : SmtpUseCase {

    override suspend fun verify(email: String, code: String): String {
        val value = redisPort.get(email)
        if((value != null) && value == code){
            return "verified"
        }
        throw RuntimeException("Smtp verification failed")
    }

    override suspend fun send(email: String): String {
        val code = stmpPort.send(email)
        redisPort.save(email,code,3L) //3분
        return "smtp success"
    }

}