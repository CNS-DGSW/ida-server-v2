package com.daegusw.apply.admission.jpa.adapter

import com.daegusw.apply.admission.jpa.adapter.repository.AdmissionJpaRepository
import com.daegusw.apply.admission.application.port.out.persistence.CommandAdmissionPort
import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.admission.jpa.adapter.common.AdmissionEntityMapper

class AdmissionCommandAdapter(
    private val admissionJpaRepository: AdmissionJpaRepository
) : CommandAdmissionPort  {
    override fun save(admission: Admission): Admission {
        return AdmissionEntityMapper.toDomain(admissionJpaRepository.save(AdmissionEntityMapper.toEntity(admission)))!!
    }
}