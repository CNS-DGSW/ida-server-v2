package com.daegusw.apply.applicant.application.service

import com.daegusw.apply.applicant.application.common.dto.InformationDto
import com.daegusw.apply.applicant.application.common.exception.ApplicantDoesNotExistException
import com.daegusw.apply.applicant.application.port.`in`.web.InformationUseCase
import com.daegusw.apply.applicant.application.port.out.persistence.CommandApplicantPort
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InformationService(
    private val queryApplicantPort: QueryApplicantPort,
    private val commandApplicantPort: CommandApplicantPort
) : InformationUseCase {
    @Transactional(readOnly = true)
    override fun find(memberId: MemberId): InformationDto {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        return InformationDto(applicant.privacy)
    }

    @Transactional
    override fun update(memberId: MemberId, information: InformationDto) {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        applicant.privacy?.updateInformation(information.name, information.birth, information.gender, information.phone)

        commandApplicantPort.save(applicant)
    }
}