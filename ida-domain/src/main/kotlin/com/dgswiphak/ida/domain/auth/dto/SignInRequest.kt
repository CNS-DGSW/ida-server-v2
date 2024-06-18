package com.dgswiphak.ida.domain.auth.dto

import jakarta.validation.constraints.NotEmpty

data class SignInRequest(
    @field:NotEmpty(message = "name is required")
    val email: String,
    @field:NotEmpty(message = "password is required")
    val password: String
)
