package com.applydgsw.member.domain.member

import com.applydgsw.member.domain.member.value.Password
import com.applydgsw.member.domain.member.value.Role
import com.applydgsw.member.id.MemberId

class Member(
    val id: MemberId,
    val email: String,
    var password: Password,
    var role: Role
) {
    fun changePassword(newPassword: Password) {
        changePassword(newPassword.value)
    }

    private fun changePassword(newPassword: String) {
        this.password = password.changePassword(newPassword)
    }
}