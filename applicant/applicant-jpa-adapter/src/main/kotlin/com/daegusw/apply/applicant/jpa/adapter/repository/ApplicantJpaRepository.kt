package com.daegusw.apply.applicant.jpa.adapter.repository

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.entity.applicant.ApplicantEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ApplicantJpaRepository : JpaRepository<ApplicantEntity, EmbeddedMemberId> {
}