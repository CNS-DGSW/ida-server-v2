package com.dgswiphak.ida.domain.notice.exception.error

import com.dgswiphak.ida.common.error.ErrorProperty
import com.dgswiphak.ida.common.error.ErrorStatus

enum class NoticeErrorCode(
    private val status: Int,
    private val message: String
) : ErrorProperty {
    NOT_FOUND_NOTICE(ErrorStatus.NOT_FOUND, "해당 공지사항을 찾지 못했습니다."),
    NOT_FOUND_ATTACHED(ErrorStatus.NOT_FOUND, "해당 첨부파일을 찾지 못했습니다."),
    ;

    override fun status(): Int = status
    override fun message(): String = message
}