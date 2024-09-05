package com.daegusw.apply.member.domain

import com.daegusw.apply.member.domain.value.Password
import com.daegusw.apply.member.domain.value.Role
import com.daegusw.apply.member.id.MemberId

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