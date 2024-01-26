package com.dgswiphak.ida.persistence.question.repository

import com.dgswiphak.ida.domain.question.model.Question
import com.dgswiphak.ida.domain.question.spi.query.CommandQuestionSpi
import com.dgswiphak.ida.persistence.question.mapper.QuestionMapper
import org.springframework.stereotype.Repository

@Repository
class CommandQuestionRepository(
    private val questionRepository: QuestionRepository,
    private val questionMapper: QuestionMapper
): CommandQuestionSpi {

    override fun save(question: Question) {
        questionRepository.save(
            questionMapper.toEntity(question)
        )
    }

    override fun delete(question: Question) {
        questionRepository.delete(
            questionMapper.toEntity(question)
        )
    }
}