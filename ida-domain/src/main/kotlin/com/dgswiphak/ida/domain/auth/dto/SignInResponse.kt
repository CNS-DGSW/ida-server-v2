package com.dgswiphak.ida.domain.auth.dto

import jakarta.validation.constraints.NotEmpty

data class SignInResponse(
    @field:NotEmpty(message = "accessToken is required")
    val accessToken: String,
    @field:NotEmpty(message = "refreshToken is required")
    val refreshToken: String
)