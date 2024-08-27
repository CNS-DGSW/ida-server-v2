package com.dgswiphak.ida.domain.admission.admission.exception

import com.dgswiphak.ida.common.error.ErrorProperty
import com.dgswiphak.ida.common.error.ErrorStatus

enum class AdmissionErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {
    NOT_FOUND(ErrorStatus.NOT_FOUND, "지원자를 찾지 못하였습니다.")
    ;
    override fun status(): Int = status
    override fun message(): String = message
}
