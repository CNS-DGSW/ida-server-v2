package com.daegusw.apply.api.security

import com.daegusw.apply.api.security.exception.CustomErrorCode
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BaseErrorResponse(

    val status: Int = HttpStatus.OK.value(),
    val state: String? = "OK",
    val message: String

) {

    constructor(code: CustomErrorCode) : this(
        status = code.status.value(),
        state = code.state,
        message = code.message
    )

}
