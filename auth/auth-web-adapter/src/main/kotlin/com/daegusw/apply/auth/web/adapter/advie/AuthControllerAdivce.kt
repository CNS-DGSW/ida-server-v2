package com.daegusw.apply.auth.web.adapter.advie

import com.daegusw.apply.auth.application.common.exception.AuthException
import com.daegusw.apply.auth.application.common.exception.LoginFailException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AuthControllerAdivce {
    @ExceptionHandler(*[AuthException::class, LoginFailException::class])
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleLoginFailException(exception: LoginFailException): ErrorResponse {
        return ErrorResponse.of(exception.message)
    }
}