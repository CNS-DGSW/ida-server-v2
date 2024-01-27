package com.dgswiphak.ida.persistence.question.repository

import com.dgswiphak.ida.domain.question.model.Question
import com.dgswiphak.ida.domain.question.spi.query.QueryQuestionSpi
import com.dgswiphak.ida.persistence.question.entity.QQuestionEntity
import com.dgswiphak.ida.persistence.question.mapper.QuestionMapper
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QueryQuestionRepository(
    private val jpaQueryFactory: JPAQueryFactory,
    private val questionMapper: QuestionMapper
) : QueryQuestionSpi {

    override fun findById(id: Long): Question? {
        val questionEntity = QQuestionEntity.questionEntity
        val entity = jpaQueryFactory.selectFrom(questionEntity)
            .where(questionEntity.id.eq(id))
            .fetchOne()

        return questionMapper.toDomain(entity)
    }

    override fun findAll(): List<Question> {
        val questionEntity = QQuestionEntity.questionEntity
        val entity = jpaQueryFactory.selectFrom(questionEntity)
            .fetch()

        return entity.map {
            questionMapper.toDomain(it)!!
        }
    }


}