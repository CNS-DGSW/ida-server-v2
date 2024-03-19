package com.dgswiphak.ida.domain.question.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.question.dto.response.QuestionResponse
import com.dgswiphak.ida.domain.question.exception.QuestionNotFoundException
import com.dgswiphak.ida.domain.question.spi.query.QueryQuestionSpi

@UseCase
class QueryQuestionDetailsUseCase(
    private val queryQuestionSpi: QueryQuestionSpi
) {

    fun execute(questionId: Long): QuestionResponse {
        val entity = queryQuestionSpi.findById(questionId)
            ?: throw QuestionNotFoundException

        return QuestionResponse.detailOf(entity)
    }
}