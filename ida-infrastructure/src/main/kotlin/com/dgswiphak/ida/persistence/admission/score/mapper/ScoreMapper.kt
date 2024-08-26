package com.dgswiphak.ida.persistence.admission.score.mapper

import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.domain.admission.score.model.GedScore
import com.dgswiphak.ida.domain.admission.score.model.SchoolScore
import com.dgswiphak.ida.domain.admission.score.model.Score
import com.dgswiphak.ida.persistence.admission.score.entity.GedScoreEntity
import com.dgswiphak.ida.persistence.admission.score.entity.SchoolScoreEntity
import com.dgswiphak.ida.persistence.admission.score.entity.ScoreEntity
import org.springframework.stereotype.Component

@Component
class ScoreMapper(
    private val schoolScoreMapper: SchoolScoreMapper,
    private val gedScoreMapper: GedScoreMapper
): Mapper<Score, ScoreEntity> {
    override fun toDomain(entity: ScoreEntity?): Score? {
        return entity?.let {
            when (entity) {
                is SchoolScoreEntity -> {
                    schoolScoreMapper.toDomain(entity)
                }
                is GedScoreEntity -> {
                    gedScoreMapper.toDomain(entity)
                }
                else -> {
                    throw java.lang.IllegalArgumentException("cannot found instance of entity!")
                }
            }
        }
    }

    override fun toEntity(domain: Score): ScoreEntity {
        return when (domain) {
            is SchoolScore -> {
                schoolScoreMapper.toEntity(domain)
            }
            is GedScore -> {
                gedScoreMapper.toEntity(domain)
            }
            else -> {
                throw IllegalArgumentException("cannot found instance of domain!")
            }
        }
    }
}
