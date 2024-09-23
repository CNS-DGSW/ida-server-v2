package com.daegusw.apply.member.domain.value

@JvmInline
value class Password(
    val value: String
) {
    fun changePassword(newPassword: String): Password {
        return Password(newPassword)
    }
}