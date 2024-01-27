package com.dgswiphak.ida.domain.question.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.question.spi.query.CommandQuestionSpi
import com.dgswiphak.ida.domain.question.spi.query.QueryQuestionSpi
import java.lang.RuntimeException

@UseCase
class DeleteQuestionUseCase(
    private val queryQuestionSpi: QueryQuestionSpi,
    private val commandQuestionSpi: CommandQuestionSpi
) {

    fun execute(questionId: Long) {
        val entity = queryQuestionSpi.findById(questionId)
            ?: throw RuntimeException()

        commandQuestionSpi.delete(entity)
    }
}