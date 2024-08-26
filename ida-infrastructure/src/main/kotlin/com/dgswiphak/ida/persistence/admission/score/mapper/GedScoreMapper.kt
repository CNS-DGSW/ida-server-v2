package com.dgswiphak.ida.persistence.admission.score.mapper

import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.domain.admission.score.model.GedScore
import com.dgswiphak.ida.domain.admission.score.model.value.grade.GedGrade
import com.dgswiphak.ida.persistence.admission.score.entity.EmbeddedScoreId
import com.dgswiphak.ida.persistence.admission.score.entity.GedScoreEntity
import com.dgswiphak.ida.persistence.admission.score.entity.value.GedGradeVO
import org.springframework.stereotype.Component

@Component
class GedScoreMapper: Mapper<GedScore, GedScoreEntity> {

    private val gradeMapper = GedGradeMapper()

    override fun toDomain(entity: GedScoreEntity?): GedScore? {
        return entity?.let {
            GedScore(
                id = it.id,
                gedScores = gradeMapper.toDomain(entity.grades)!!,
                participate = it.participate
            )
        }
    }

    override fun toEntity(domain: GedScore): GedScoreEntity {
        return GedScoreEntity(
            id = domain.id!!,
            grades = gradeMapper.toEntity(domain.gedScores),
            participate = domain.participate
        )
    }

    inner class GedGradeMapper : Mapper<List<GedGrade>, List<GedGradeVO>> {
        override fun toDomain(entity: List<GedGradeVO>?): List<GedGrade>? {
            return entity?.let {
                it.stream().map {
                    vo -> GedGrade(
                        subject = vo.subject,
                        score = vo.score
                )
                }.toList()
            }
        }

        override fun toEntity(domain: List<GedGrade>): List<GedGradeVO> {
            return domain.stream().map {
                GedGradeVO(
                    subject = it.subject,
                    score = it.score
                )
            }.toList()
        }

    }
}
