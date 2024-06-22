package com.dgswiphak.ida.domain.question.dto.request

import jakarta.validation.constraints.NotNull

data class UpdateQuestionRequest(
    @field:NotNull(message = "title is required")
    val title: String,
    @field:NotNull(message = "content is required")
    val content: String
)
