package com.daegusw.apply.api.security.exception

import org.springframework.http.HttpStatus

interface CustomErrorCode {

    val status: HttpStatus
    val state: String
    val message: String

}
