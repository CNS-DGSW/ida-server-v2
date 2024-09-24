package com.daegusw.apply.admission.web.adapter.advice

import com.daegusw.apply.admission.application.common.exception.AdmissionDoesNotExistException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class AdmissionExceptionAdvice {
    @ExceptionHandler(AdmissionDoesNotExistException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleMemberDoesNotExistException(exception: AdmissionDoesNotExistException): ErrorResponse {
        return ErrorResponse.of(exception.message)
    }
}