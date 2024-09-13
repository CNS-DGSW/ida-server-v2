package com.daegusw.apply.admission.jpa.adapter.repository

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.entity.admission.AdmissionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AdmissionJpaRepository : JpaRepository<AdmissionEntity, Long> {
    @Query("SELECT a from AdmissionEntity as a where a.applicant.member = :id")
    fun findByMemberId(@Param("id") id: EmbeddedMemberId): AdmissionEntity?
}
