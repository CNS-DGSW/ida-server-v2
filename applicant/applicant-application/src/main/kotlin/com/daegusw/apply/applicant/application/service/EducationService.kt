package com.daegusw.apply.applicant.application.service

import com.daegusw.apply.applicant.application.common.exception.ApplicantDoesNotExistException
import com.daegusw.apply.applicant.application.port.`in`.web.EducationUseCase
import com.daegusw.apply.applicant.application.port.out.persistence.CommandApplicantPort
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import com.daegusw.apply.applicant.domain.applicant.education.Education
import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EducationService(
    private val queryApplicantPort: QueryApplicantPort,
    private val commandApplicantPort: CommandApplicantPort,
) : EducationUseCase {
    @Transactional(readOnly = true)
    override fun find(memberId: MemberId): GraduationType {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        return applicant.education?.graduationType ?: GraduationType.EXPECTED
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun update(memberId: MemberId, graduationType: GraduationType) {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        applicant.updateEducation(Education(graduationType))

        commandApplicantPort.save(applicant)
    }
}