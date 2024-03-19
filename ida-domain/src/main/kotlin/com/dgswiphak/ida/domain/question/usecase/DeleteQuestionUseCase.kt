package com.dgswiphak.ida.domain.question.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.question.exception.QuestionNotFoundException
import com.dgswiphak.ida.domain.question.spi.query.CommandQuestionSpi
import com.dgswiphak.ida.domain.question.spi.query.QueryQuestionSpi

@UseCase
class DeleteQuestionUseCase(
    private val queryQuestionSpi: QueryQuestionSpi,
    private val commandQuestionSpi: CommandQuestionSpi
) {

    fun execute(questionId: Long) {
        val entity = queryQuestionSpi.findById(questionId)
            ?: throw QuestionNotFoundException

        commandQuestionSpi.delete(entity)
    }
}