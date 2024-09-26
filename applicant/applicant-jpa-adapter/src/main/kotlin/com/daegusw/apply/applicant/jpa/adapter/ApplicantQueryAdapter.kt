package com.daegusw.apply.applicant.jpa.adapter

import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import com.daegusw.apply.applicant.domain.applicant.Applicant
import com.daegusw.apply.applicant.jpa.adapter.common.ApplicantEntityMapper
import com.daegusw.apply.applicant.jpa.adapter.repository.ApplicantJpaRepository
import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.member.id.MemberId
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ApplicantQueryAdapter(
    private val applicantJpaRepository: ApplicantJpaRepository
) : QueryApplicantPort {
    override fun findById(id: MemberId): Applicant? {
        return ApplicantEntityMapper.toDomain(applicantJpaRepository.findByIdOrNull(EmbeddedMemberId(id.value)))
    }

    override fun findAll(): List<Applicant> {
        return applicantJpaRepository.findAll().map {
            ApplicantEntityMapper.toDomain(it)!!
        }
    }
}