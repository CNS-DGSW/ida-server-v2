package com.applydgsw.member.domain.member.value

@JvmInline
value class Password(
    val value: String
) {
    fun changePassword(newPassword: String): Password {
        return Password(newPassword)
    }
}