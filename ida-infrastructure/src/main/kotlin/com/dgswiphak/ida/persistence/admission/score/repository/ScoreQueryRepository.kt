package com.dgswiphak.ida.persistence.admission.score.repository

import com.dgswiphak.ida.domain.admission.score.model.Score
import com.dgswiphak.ida.domain.admission.score.spi.query.QueryScoreSpi
import com.dgswiphak.ida.persistence.admission.score.entity.QScoreEntity
import com.dgswiphak.ida.persistence.admission.score.mapper.ScoreMapper
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ScoreQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory,
    private val scoreMapper: ScoreMapper
) : QueryScoreSpi {
    override fun findById(id: Long): Score? {
        val scoreEntity = QScoreEntity.scoreEntity
        val score = jpaQueryFactory.selectFrom(scoreEntity)
            .where(scoreEntity.id.eq(id))
            .fetchOne()

        return scoreMapper.toDomain(score)
    }
}
