package com.dgswiphak.ida.aggregate.auth

import com.dgswiphak.ida.domain.auth.dto.SignInRequest
import com.dgswiphak.ida.domain.auth.dto.SignInResponse
import com.dgswiphak.ida.domain.auth.usecase.SignInUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController (
    private val signInUseCase: SignInUseCase
){
    @PostMapping("/signIn")
    @ResponseStatus(HttpStatus.OK)
    fun execute(
        @Valid @RequestBody request: SignInRequest
    ) : SignInResponse {
        return signInUseCase.execute(request)
    }
}