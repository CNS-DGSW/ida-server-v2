package com.daegusw.apply.notice.web.adapter.request

import com.daegusw.apply.notice.application.common.NoticeCommand
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateNoticeRequest(
    @field:NotEmpty(message = "title is required")
    val title: String,

    @field:NotEmpty(message = "content is required")
    val content: String,

    @field:NotNull(message = "isMajor is required")
    val isMajor: Boolean
) {
    fun toCommand() = NoticeCommand(
        title = title,
        content =  content,
        isMajor = isMajor
    )
}