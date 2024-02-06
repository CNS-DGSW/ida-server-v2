package com.dgswiphak.ida.domain.auth.dto

data class SignInResponse(
    val accessToken: String,
    val refreshToken: String
)