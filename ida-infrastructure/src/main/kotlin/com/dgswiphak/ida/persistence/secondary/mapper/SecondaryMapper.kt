package com.dgswiphak.ida.persistence.secondary.mapper

import com.dgswiphak.ida.domain.secondary.domain.Secondary
import com.dgswiphak.ida.domain.secondary.domain.value.Aptitude
import com.dgswiphak.ida.domain.secondary.domain.value.Interview
import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.persistence.secondary.entity.SecondaryEntity
import com.dgswiphak.ida.persistence.secondary.entity.value.AptitudeVO
import com.dgswiphak.ida.persistence.secondary.entity.value.InterviewVO
import org.springframework.stereotype.Component

@Component
class SecondaryMapper(
    private val aptitudeMapper: AptitudeMapper,
    private val interviewMapper: InterviewMapper
) : Mapper<Secondary, SecondaryEntity> {

    override fun toDomain(entity: SecondaryEntity?): Secondary? {
        return entity?.let {
            Secondary(
                id = it.id,
                aptitude = aptitudeMapper.toDomain(it.aptitudeVO)!!,
                interview = interviewMapper.toDomain(it.interviewVO)!!
            )
        }
    }

    override fun toEntity(domain: Secondary): SecondaryEntity {
        return SecondaryEntity(
            id = domain.id,
            aptitudeVO = aptitudeMapper.toEntity(domain.aptitude),
            interviewVO = interviewMapper.toEntity(domain.interview)
        )
    }
}

@Component
class AptitudeMapper : Mapper<Aptitude, AptitudeVO> {
    override fun toDomain(entity: AptitudeVO?): Aptitude? {
        return entity?.let {
            Aptitude(
                jopScore = it.jopScore
            )
        }
    }

    override fun toEntity(domain: Aptitude): AptitudeVO {
        return AptitudeVO(
            jopScore = domain.jopScore
        )
    }
}

@Component
class InterviewMapper : Mapper<Interview, InterviewVO> {
    override fun toDomain(entity: InterviewVO?): Interview? {
        return entity?.let {
            Interview(
                studyCompetence = it.studyCompetence,
                computingCompetence = it.computingCompetence
            )
        }
    }

    override fun toEntity(domain: Interview): InterviewVO {
        return InterviewVO(
            studyCompetence = domain.studyCompetence,
            computingCompetence = domain.computingCompetence
        )
    }
}