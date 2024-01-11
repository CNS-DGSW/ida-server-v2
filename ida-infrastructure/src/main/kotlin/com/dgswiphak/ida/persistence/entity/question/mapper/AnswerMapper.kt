package com.dgswiphak.ida.persistence.entity.question.mapper

import com.dgswiphak.ida.domain.question.domain.Answer
import com.dgswiphak.ida.persistence.common.mapper.Mapper
import com.dgswiphak.ida.persistence.entity.question.entity.AnswerEntity

class AnswerMapper(
    private val questionMapper: QuestionMapper
) : Mapper<Answer, AnswerEntity> {

    override fun toDomain(entity: AnswerEntity?): Answer? {
        return entity?.let {
            Answer(
                id = it.id,
                content = it.content,
                createDate = it.createDate,
                question = questionMapper.toDomain(it.questionEntity)!!
            )
        }
    }

    override fun toEntity(domain: Answer): AnswerEntity {
        return AnswerEntity(
            id = domain.id,
            content = domain.content,
            createDate = domain.createDate,
            questionEntity = questionMapper.toEntity(domain.question)
        )
    }
}