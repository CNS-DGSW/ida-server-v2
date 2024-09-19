package com.daegusw.apply.admission.jpa.adapter.repository

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.entity.admission.AdmissionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AdmissionJpaRepository : JpaRepository<AdmissionEntity, Long>{
    fun findByApplicant_Member(id: EmbeddedMemberId): AdmissionEntity?
}