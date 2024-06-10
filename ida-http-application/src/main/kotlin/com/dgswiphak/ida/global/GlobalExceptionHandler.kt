package com.dgswiphak.ida.global

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.global.error.ErrorResponse
import com.dgswiphak.ida.global.error.GlobalErrorCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(IdaException::class)
    fun businessException(
        e: IdaException
    ) = ErrorResponse.of(e.errorProperty)

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        e.printStackTrace()
        return ResponseEntity
            .status(GlobalErrorCode.INTERNATIONAL_SERVER_ERROR.status())
            .body(ErrorResponse.of(GlobalErrorCode.INTERNATIONAL_SERVER_ERROR))
    }
}