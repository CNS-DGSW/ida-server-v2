package com.daegusw.apply.applicant.web.adapter.advice

import com.fasterxml.jackson.annotation.JsonProperty

class ErrorResponse private constructor(
    @field:JsonProperty(value = "response_messages")
    private val message: String?
) {
    companion object {
        fun of(message: String?): ErrorResponse {
            return ErrorResponse(message)
        }
    }
}