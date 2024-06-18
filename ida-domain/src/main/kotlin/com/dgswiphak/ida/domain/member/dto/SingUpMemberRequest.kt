package com.dgswiphak.ida.domain.member.dto

import jakarta.validation.constraints.NotEmpty

data class SingUpMemberRequest(
        @field:NotEmpty(message = "email is required")
        val email: String,
        @field:NotEmpty(message = "password is required")
        val password: String
)