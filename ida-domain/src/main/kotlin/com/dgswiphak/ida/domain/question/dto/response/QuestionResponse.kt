package com.dgswiphak.ida.domain.question.dto.response

import com.dgswiphak.ida.domain.question.model.Question

data class QuestionResponse(
    val id: Long,
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
    val notices: List<QuestionResponse>
)
