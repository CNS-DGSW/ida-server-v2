package com.daegusw.apply.applicant.application.port.out.smtp

interface SmtpPort {
    fun send(e: String) : String
    fun verify(e: String) : String
}