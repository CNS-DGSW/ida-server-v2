package com.dgswiphak.ida.persistence.admission.admission.repository

import com.dgswiphak.ida.persistence.admission.admission.entity.AdmissionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdmissionRepository : JpaRepository<AdmissionEntity, Long> {
}
