package com.dgswiphak.ida.domain.notice.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class CreateNoticeRequest(
    @field:NotEmpty(message = "title is required")
    val title: String,

    @field:NotEmpty(message = "content is required")
    val content: String,

    @field:NotNull(message = "isMajor is required")
    val isMajor: Boolean
)