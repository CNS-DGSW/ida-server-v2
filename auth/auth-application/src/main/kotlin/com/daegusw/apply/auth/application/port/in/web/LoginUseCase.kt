package com.daegusw.apply.auth.application.port.`in`.web

import com.daegusw.apply.auth.application.LoginMember
import com.daegusw.apply.auth.application.TokenDto

interface LoginUseCase {
    fun login(loginMember: LoginMember): TokenDto
}