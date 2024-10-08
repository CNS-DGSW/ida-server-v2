package com.daegusw.apply.applicant.web.adapter.advice

import com.daegusw.apply.applicant.application.common.exception.ApplicantDoesNotExistException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApplicantExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ApplicantDoesNotExistException::class)
    fun handleApplicantDoesNotExistException(exception: ApplicantDoesNotExistException): ErrorResponse {
        return ErrorResponse.of(exception.message)
    }
}