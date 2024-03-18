package com.dgswiphak.ida.domain.member.exception.error

import com.dgswiphak.ida.common.error.ErrorProperty
import com.dgswiphak.ida.common.error.ErrorStatus

enum class MemberErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {
    NOT_FOUND(ErrorStatus.NOT_FOUND, "지석이를 찾지 못하였습니다.");

    override fun status(): Int = status
    override fun message(): String = message
}