package com.dgswiphak.ida.persistence.applicant.repository

import com.dgswiphak.ida.domain.applicant.model.Applicant
import com.dgswiphak.ida.domain.applicant.spi.query.CommandApplicantSpi
import com.dgswiphak.ida.persistence.applicant.mapper.ApplicantMapper
import org.springframework.stereotype.Repository

@Repository
class ApplicantCommandRepository(
    private val applicantRepository: ApplicantRepository,
    private val applicantMapper: ApplicantMapper
) : CommandApplicantSpi{
    override fun save(applicant: Applicant): Applicant? {
         return applicantMapper.toDomain(applicantRepository.save(applicantMapper.toEntity(applicant)))
    }
}