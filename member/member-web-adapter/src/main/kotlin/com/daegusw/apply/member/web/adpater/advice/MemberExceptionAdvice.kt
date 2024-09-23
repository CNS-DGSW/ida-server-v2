package com.daegusw.apply.member.web.adpater.advice

import com.daegusw.apply.memnber.application.common.MemberDoesNotExistException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class MemberExceptionAdvice {
    @ExceptionHandler(MemberDoesNotExistException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleMemberDoesNotExistException(exception: MemberDoesNotExistException): ErrorResponse {
        return ErrorResponse.of(exception.message)
    }
}