package com.dgswiphak.ida.domain.auth

import com.dgswiphak.ida.domain.auth.dto.SignInRequest
import com.dgswiphak.ida.domain.auth.dto.SignInResponse
import com.dgswiphak.ida.domain.auth.usecase.SignInUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController (
    private val signInUseCase: SignInUseCase
){
    @GetMapping("/signIn")
    @ResponseStatus(HttpStatus.OK)
    fun execute(
        @RequestBody request: SignInRequest
    ) : SignInResponse {
        return signInUseCase.execute(request)
    }
}