package com.dgswiphak.ida.domain.question.dto.request

import jakarta.validation.constraints.NotEmpty

data class CreateQuestionRequest(
    @field:NotEmpty(message = "title is required")
    val title: String,
    @field:NotEmpty(message = "content is required")
    val content: String
)