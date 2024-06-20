package com.dgswiphak.ida.domain.member.dto

import com.dgswiphak.ida.common.annotation.ValidPassword
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class SingUpMemberRequest(
        @field:Email(message = "Must be a valid email address")
        @field:NotEmpty(message = "email is required")
        val email: String,
        @field:NotEmpty(message = "password is required")
        @field:ValidPassword
        val password: String
)