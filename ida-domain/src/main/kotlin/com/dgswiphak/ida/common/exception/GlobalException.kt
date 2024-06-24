package com.dgswiphak.ida.common.exception

import com.dgswiphak.ida.common.error.ErrorProperty
import com.dgswiphak.ida.common.error.ErrorStatus

enum class GlobalException(
    private val status: Int,
    private val message: String
) : ErrorProperty {
    FILE_TYPE_ERROR(ErrorStatus.BAD_REQUEST, "파일 형식이 잘못 되었습니다.");

    override fun status(): Int = status
    override fun message(): String = message
}