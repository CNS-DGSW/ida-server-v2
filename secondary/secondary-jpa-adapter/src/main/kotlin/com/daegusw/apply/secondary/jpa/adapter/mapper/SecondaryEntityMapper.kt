package com.daegusw.apply.secondary.jpa.adapter.mapper

import com.daegusw.apply.admission.jpa.adapter.common.AdmissionEntityMapper
import com.daegusw.apply.core.data.entity.secondary.SecondaryEntity
import com.daegusw.apply.core.data.entity.secondary.value.AptitudeVO
import com.daegusw.apply.core.data.entity.secondary.value.ExamineeVO
import com.daegusw.apply.core.data.entity.secondary.value.InterviewVO
import com.daegusw.apply.secondary.domain.Secondary
import com.daegusw.apply.secondary.domain.value.Aptitude
import com.daegusw.apply.secondary.domain.value.Examinee
import com.daegusw.apply.secondary.domain.value.Interview

object SecondaryEntityMapper {
    fun toEntity(domain: Secondary): SecondaryEntity {
        return SecondaryEntity(
            id = domain.id!!,
            examinee = toExamineeVO(domain.examinee),
            aptitude = toAptitudeVO(domain.aptitude),
            interview = toInterviewVO(domain.interview),
        )
    }
    fun toDomain(entity: SecondaryEntity?): Secondary? {
        return entity?.let {
            Secondary(
                id = it.id,
                examinee = toExaminee(it.examinee),
                aptitude = toAptitude(it.aptitude),
                interview = toInterview(it.interview)
            )
        }
    }

    private fun toExamineeVO(domain: Examinee): ExamineeVO {
        return ExamineeVO(
            admission = AdmissionEntityMapper.toEntity(domain.admission),
            examCode = domain.examCode
        )
    }

    private fun toExaminee(entity: ExamineeVO): Examinee {
        return Examinee(
            admission = AdmissionEntityMapper.toDomain(entity.admission)!!,
            examCode = entity.examCode
        )
    }

    private fun toAptitude(domain: AptitudeVO): Aptitude {
        return Aptitude(
            jobScore = domain.jopScore
        )
    }

    private fun toAptitudeVO(domain: Aptitude): AptitudeVO {
        return AptitudeVO(
            jopScore = domain.jobScore
        )
    }

    private fun toInterview(domain: InterviewVO): Interview {
        return Interview(
            studyScore = domain.studyScore,
            computingScore = domain.computingScore
        )
    }

    private fun toInterviewVO(domain: Interview): InterviewVO {
        return InterviewVO(
            studyScore = domain.studyScore,
            computingScore = domain.computingScore
        )
    }
}