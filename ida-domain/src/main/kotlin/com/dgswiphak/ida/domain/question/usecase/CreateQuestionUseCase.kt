package com.dgswiphak.ida.domain.question.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.question.dto.request.CreateQuestionRequest
import com.dgswiphak.ida.domain.question.model.Question
import com.dgswiphak.ida.domain.question.spi.query.CommandQuestionSpi
import java.time.LocalDateTime

@UseCase
class CreateQuestionUseCase(
    private val commandQuestionSpi: CommandQuestionSpi
) {

    fun execute(request: CreateQuestionRequest) {
        val question = Question(
            title = request.title,
            content = request.content,
        )

        commandQuestionSpi.save(question)
    }
}