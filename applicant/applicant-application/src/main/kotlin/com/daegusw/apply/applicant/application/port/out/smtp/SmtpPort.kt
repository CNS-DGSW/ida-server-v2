package com.daegusw.apply.applicant.application.port.out.smtp

interface SmtpPort {
    suspend fun send(e: String) : String
}