package com.daegusw.apply.member.web.adpater.api.request

import com.daegusw.apply.memnber.application.common.MemberCommand
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

data class SignupMemberRequest(
    @field:NotEmpty(message = "필수 값 입니다.")
    @field:Email(message = "이메일 형식을 지켜야합니다.")
    val email: String,

    @field:NotEmpty(message = "password is required")
    @field:Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[~!@#$%^&*|'\":₩\\\\?]).{9,}", message = "Invalid Password")
    val password: String
) {
    fun toCommand() = MemberCommand(
        email = email,
        password = password
    )
}