package com.daegusw.apply.applicant.application.service

import com.daegusw.apply.applicant.application.common.dto.ParentDto
import com.daegusw.apply.applicant.application.common.exception.ApplicantDoesNotExistException
import com.daegusw.apply.applicant.application.port.`in`.web.ParentUseCase
import com.daegusw.apply.applicant.application.port.out.persistence.CommandApplicantPort
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ParentService(
    private val queryApplicantPort: QueryApplicantPort,
    private val commandApplicantPort: CommandApplicantPort
) : ParentUseCase {
    @Transactional(readOnly = true)
    override fun find(memberId: MemberId): ParentDto {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        return ParentDto(applicant.privacy?.parent, applicant.privacy?.address)
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun update(memberId: MemberId, dto: ParentDto) {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        applicant.privacy?.updateParent(dto.toParent())
        applicant.privacy?.updateAddress(dto.toAddress())

        commandApplicantPort.save(applicant)
    }
}