package com.dgswiphak.ida.persistence.applicant.repository

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.persistence.applicant.entity.ApplicantEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ApplicantRepository : CrudRepository<ApplicantEntity, MemberId> {
}