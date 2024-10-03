package com.daegusw.apply.secondary.jpa.adapter.repository

import com.daegusw.apply.core.data.entity.admission.AdmissionEntity
import com.daegusw.apply.core.data.entity.secondary.SecondaryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SecondaryRepository : JpaRepository<SecondaryEntity, Long> {
    fun findByExaminee_Admission(admission: AdmissionEntity): SecondaryEntity?
}