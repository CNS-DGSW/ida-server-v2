package com.dgswiphak.ida.global

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.global.error.ErrorResponse
import com.dgswiphak.ida.global.error.GlobalErrorCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val errorMessage = ex.bindingResult.allErrors.map { it.defaultMessage }.joinToString(", ")
        return ResponseEntity(
            ErrorResponse(status = 400, message = errorMessage ?: "Validation failed"),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        val errorMessage = "Invalid request body: ${ex.message}"
        return ResponseEntity(
            ErrorResponse(status = 400, message = errorMessage),
            HttpStatus.BAD_REQUEST
        )
    }

}