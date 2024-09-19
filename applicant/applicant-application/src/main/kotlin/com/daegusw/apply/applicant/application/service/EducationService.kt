package com.daegusw.apply.applicant.application.service

import com.daegusw.apply.applicant.application.common.dto.EducationDto
import com.daegusw.apply.applicant.application.common.exception.ApplicantDoesNotExistException
import com.daegusw.apply.applicant.application.port.`in`.web.EducationUseCase
import com.daegusw.apply.applicant.application.port.out.persistence.CommandApplicantPort
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EducationService(
    private val queryApplicantPort: QueryApplicantPort,
    private val commandApplicantPort: CommandApplicantPort,
) : EducationUseCase {
    @Transactional(readOnly = true)
    override fun find(memberId: MemberId): EducationDto {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        return EducationDto(applicant.education?.graduationType, applicant.education?.graduateYear, applicant.education?.school, applicant.education?.teacher)
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun update(memberId: MemberId, education: EducationDto) {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        applicant.education?.updateSchool(education.toSchool())
        applicant.education?.updateTeacher(education.toTeacher())

        commandApplicantPort.save(applicant)
    }
}