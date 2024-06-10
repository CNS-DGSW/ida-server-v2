package com.dgswiphak.ida.global.error

import com.dgswiphak.ida.common.error.ErrorProperty

class ErrorResponse(
    val status: Int,
    val message: String
) {
    companion object {
        fun of(errorProperty: ErrorProperty): ErrorResponse {
            return ErrorResponse(
                status = errorProperty.status(),
                message =  errorProperty.message())
        }
    }
}