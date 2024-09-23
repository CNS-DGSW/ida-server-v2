package com.daegusw.apply.applicant.web.adapter.api.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class SmtpRequest(
    @field:Email(message = "email is required")
    val email: String,
    @field:NotEmpty(message = "code is required")
    val code: String,
)
