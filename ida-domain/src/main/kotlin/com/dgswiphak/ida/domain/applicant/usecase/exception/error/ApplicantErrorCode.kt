package com.dgswiphak.ida.domain.applicant.usecase.exception.error

import com.dgswiphak.ida.common.error.ErrorProperty
import com.dgswiphak.ida.common.error.ErrorStatus

enum class ApplicantErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {
    NOT_FOUND(ErrorStatus.NOT_FOUND, "해당 자료가 존재하지 않습니다."),
    TYPE_ERROR(ErrorStatus.BAD_REQUEST, "파일 형식이 잘못 되었습니다.");

    override fun status(): Int = status
    override fun message(): String = message
}