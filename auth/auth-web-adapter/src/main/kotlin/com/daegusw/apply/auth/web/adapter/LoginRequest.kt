package com.daegusw.apply.auth.web.adapter

import com.daegusw.apply.auth.application.LoginMember
import javax.validation.constraints.NotEmpty

data class LoginRequest(
    @field:NotEmpty(message = "이메일은 필수 속성입니다.")
    val email: String,
    @field:NotEmpty(message = "비밀번호는 필수 속성입니다.")
    val password: String
) {
    fun toLogin() = LoginMember(
        email = email,
        password = password
    )
}