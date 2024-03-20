package com.dgswiphak.ida.domain.question.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.question.dto.request.UpdateQuestionRequest
import com.dgswiphak.ida.domain.question.exception.QuestionNotFoundException
import com.dgswiphak.ida.domain.question.spi.query.CommandQuestionSpi
import com.dgswiphak.ida.domain.question.spi.query.QueryQuestionSpi

@UseCase
class UpdateQuestionUseCase(
    private val queryQuestionSpi: QueryQuestionSpi,
    private val commandQuestionSpi: CommandQuestionSpi
) {

    fun execute(questionId: Long, request: UpdateQuestionRequest) {
        val question = queryQuestionSpi.findById(questionId)
            ?: throw QuestionNotFoundException

        commandQuestionSpi.save(
            question.copy(
                title = request.title,
                content = request.content
            )
        )
    }
}