package com.dgswiphak.ida.domain.auth.exception.error

import com.dgswiphak.ida.common.error.ErrorProperty
import com.dgswiphak.ida.common.error.ErrorStatus

enum class TokenErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {
    EXPIRED_TOKEN(ErrorStatus.UNAUTHORIZED, "토큰이 만료 되었습니다."),
    INVALID_TOKEN(ErrorStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    ;

    override fun status(): Int = status
    override fun message(): String = message
}