package com.daegusw.apply.auth.web.adapter

import com.daegusw.apply.auth.application.TokenDto
import com.daegusw.apply.auth.application.port.`in`.web.LoginUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val loginUseCase: LoginUseCase
) {
    @PostMapping("/login")
    fun login(
        @RequestBody request: LoginRequest
    ): TokenDto {
        return loginUseCase.login(request.toLogin())
    }
}