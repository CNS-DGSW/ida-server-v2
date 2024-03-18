package com.dgswiphak.ida.global.error

import com.dgswiphak.ida.common.error.ErrorProperty
import com.dgswiphak.ida.common.error.ErrorStatus

enum class GlobalErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {
    INTERNATIONAL_SERVER_ERROR(ErrorStatus.INTERNATIONAL_SERVER_ERROR, "International Sever Error");

    override fun status(): Int = status
    override fun message(): String = message
}