package com.dgswiphak.ida.domain.question.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.question.dto.response.QuestionResponse
import com.dgswiphak.ida.domain.question.dto.response.QuestionsResponse
import com.dgswiphak.ida.domain.question.spi.query.QueryQuestionSpi

@UseCase
class QueryQuestionAllUseCase(
    private val queryQuestionSpi: QueryQuestionSpi
) {

    fun execute(): QuestionsResponse {
        val questions = queryQuestionSpi.findAll()

        return QuestionsResponse(
            questions.map {
                QuestionResponse.of(it)
            }
        )
    }
}