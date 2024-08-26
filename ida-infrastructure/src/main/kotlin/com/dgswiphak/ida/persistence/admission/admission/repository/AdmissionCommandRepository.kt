package com.dgswiphak.ida.persistence.admission.admission.repository

import com.dgswiphak.ida.domain.admission.admission.model.Admission
import com.dgswiphak.ida.domain.admission.admission.spi.CommandAdmissionSpi
import com.dgswiphak.ida.persistence.admission.admission.mapper.AdmissionMapper
import org.springframework.stereotype.Repository

@Repository
class AdmissionCommandRepository(
    private val admissionRepository: AdmissionRepository,
    private val admissionMapper: AdmissionMapper
) : CommandAdmissionSpi {
    override fun save(admission: Admission): Admission? {
        return admissionMapper.toDomain(admissionRepository.save(admissionMapper.toEntity(admission)))
    }
}
