package com.dgswiphak.ida.domain.auth.model

enum class TokenType (
    val identity: String
) {
    ACCESS_TOKEN("access"),
    REFRESH_TOKEN("refresh")
}