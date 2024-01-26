package com.dgswiphak.ida.domain.question.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.question.dto.response.QuestionResponse
import com.dgswiphak.ida.domain.question.spi.query.QueryQuestionSpi
import java.lang.RuntimeException

@UseCase
class QueryQuestionDetailsUseCase(
    private val queryQuestionSpi: QueryQuestionSpi
) {

    fun execute(questionId: Long): QuestionResponse {
        val entity = queryQuestionSpi.findById(questionId)
            ?: throw RuntimeException()

        return QuestionResponse.detailOf(entity)
    }
}