package com.daegusw.apply.applicant.application.service

import com.daegusw.apply.applicant.application.common.dto.SchoolDto
import com.daegusw.apply.applicant.application.common.dto.SchoolResponse
import com.daegusw.apply.applicant.application.common.exception.ApplicantDoesNotExistException
import com.daegusw.apply.applicant.application.port.`in`.web.SchoolUseCase
import com.daegusw.apply.applicant.application.port.out.client.SchoolSearchWebClientPort
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service

@Service
class SchoolService(
    private val queryApplicantPort: QueryApplicantPort,
    private val schoolSearchWebClientPort: SchoolSearchWebClientPort
) : SchoolUseCase {
    override fun find(id: MemberId): SchoolDto {
        val applicant = queryApplicantPort.findById(id) ?: throw ApplicantDoesNotExistException(id)

        return SchoolDto(applicant.education?.school)
    }

    override fun update(id: MemberId, dto: SchoolDto) {
        val applicant = queryApplicantPort.findById(id) ?: throw ApplicantDoesNotExistException(id)

        applicant.education?.updateSchool(dto.toSchool())
    }

    override fun search(q: String): List<SchoolResponse> {
        return schoolSearchWebClientPort.search(q)
    }
}