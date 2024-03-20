package com.dgswiphak.ida.domain.question.exception.error

import com.dgswiphak.ida.common.error.ErrorProperty
import com.dgswiphak.ida.common.error.ErrorStatus

enum class QuestionErrorCode(
    private val status: Int,
    private val message: String
): ErrorProperty {
    NOT_FOUND(ErrorStatus.NOT_FOUND, "해당 질문은 존재하지 않습니다.");

    override fun status(): Int = status
    override fun message(): String = message
}