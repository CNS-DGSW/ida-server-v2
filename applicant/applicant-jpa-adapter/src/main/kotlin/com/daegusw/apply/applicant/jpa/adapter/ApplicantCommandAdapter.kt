package com.daegusw.apply.applicant.jpa.adapter

import com.daegusw.apply.applicant.application.port.out.persistence.CommandApplicantPort
import com.daegusw.apply.applicant.domain.applicant.Applicant
import com.daegusw.apply.applicant.jpa.adapter.common.ApplicantEntityMapper
import com.daegusw.apply.applicant.jpa.adapter.repository.ApplicantJpaRepository
import org.springframework.stereotype.Repository

@Repository
class ApplicantCommandAdapter(
    private val applicantJpaRepository: ApplicantJpaRepository
) : CommandApplicantPort{
    override fun save(applicant: Applicant) {
        applicantJpaRepository.save(ApplicantEntityMapper.toEntity(applicant))
    }
}