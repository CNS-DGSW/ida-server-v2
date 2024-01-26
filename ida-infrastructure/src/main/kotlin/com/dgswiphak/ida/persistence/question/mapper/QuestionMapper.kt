package com.dgswiphak.ida.persistence.question.mapper

import com.dgswiphak.ida.domain.question.model.Question
import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.persistence.question.entity.QuestionEntity
import org.springframework.stereotype.Component

@Component
class QuestionMapper : Mapper<Question, QuestionEntity> {

    override fun toDomain(entity: QuestionEntity?): Question? {
        return entity?.let {
            Question(
                id = it.id,
                title = it.title,
                content = it.content,
                createdAt = it.createdAt,
                updatedAt = it.updatedAt
            )
        }
    }

    override fun toEntity(domain: Question): QuestionEntity {
        return QuestionEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            createdAt = domain.createdAt,
            updatedAt = domain.updatedAt
        )
    }
}