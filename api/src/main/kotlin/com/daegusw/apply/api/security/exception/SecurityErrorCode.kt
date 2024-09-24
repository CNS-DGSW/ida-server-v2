package com.daegusw.apply.api.security.exception

import org.springframework.http.HttpStatus

enum class SecurityErrorCode(
    override val status: HttpStatus,
    override val state: String,
    override val message: String,
) : CustomErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND", "요청을 찾을 수 없습니다."),
    FORBIDDEN_REQUEST(HttpStatus.FORBIDDEN, "FORBIDDEN", "요청에 대한 권한이 없습니다.")

}
