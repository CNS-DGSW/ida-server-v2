package com.daegusw.apply.applicant.application.port.`in`.web

interface SmtpUseCase {
    suspend fun verify(email: String, code: String): String
    suspend fun send(email: String): String
}