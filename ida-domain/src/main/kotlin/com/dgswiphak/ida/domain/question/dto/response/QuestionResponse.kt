package com.dgswiphak.ida.domain.question.dto.response

import com.dgswiphak.ida.domain.question.model.Question
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class QuestionResponse(
    @field:NotNull(message = "id is required")
    val id: Long,
    @field:NotEmpty(message = "title is required")
    val title: String,
    val content: String? = null
) {
    companion object {
        fun of(question: Question): QuestionResponse {
            return QuestionResponse(
                id = question.id!!,
                title = question.title
            )
        }

        fun detailOf(question: Question): QuestionResponse {
            return QuestionResponse(
                id = question.id!!,
                title = question.title,
                content = question.content
            )
        }
    }
}

data class QuestionsResponse(
    @field:NotNull(message = "notices is required")
    val notices: List<QuestionResponse>
)
