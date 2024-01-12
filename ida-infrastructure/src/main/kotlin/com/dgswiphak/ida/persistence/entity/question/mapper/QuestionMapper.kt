package com.dgswiphak.ida.persistence.entity.question.mapper

import com.dgswiphak.ida.domain.question.domain.Question
import com.dgswiphak.ida.persistence.common.mapper.Mapper
import com.dgswiphak.ida.persistence.entity.question.entity.QuestionEntity
import org.springframework.stereotype.Component

@Component
class QuestionMapper : Mapper<Question, QuestionEntity> {

    override fun toDomain(entity: QuestionEntity?): Question? {
        return entity?.let {
            Question(
                id = it.id,
                title = it.title,
                content = it.content,
                createDate = it.createDate
            )
        }
    }

    override fun toEntity(domain: Question): QuestionEntity {
        return QuestionEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            createDate = domain.createDate
        )
    }
}