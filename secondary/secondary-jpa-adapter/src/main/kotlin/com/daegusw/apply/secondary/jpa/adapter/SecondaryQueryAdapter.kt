package com.daegusw.apply.secondary.jpa.adapter

import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.admission.jpa.adapter.common.AdmissionEntityMapper
import com.daegusw.apply.secondary.application.QuerySecondaryPort
import com.daegusw.apply.secondary.domain.Secondary
import com.daegusw.apply.secondary.jpa.adapter.mapper.SecondaryEntityMapper
import com.daegusw.apply.secondary.jpa.adapter.repository.SecondaryRepository
import org.springframework.stereotype.Repository

@Repository
class SecondaryQueryAdapter(
    private val secondaryRepository: SecondaryRepository
) : QuerySecondaryPort {
    override fun findByAdmission(admission: Admission): Secondary? {
        return SecondaryEntityMapper.toDomain(secondaryRepository.findByExaminee_Admission(AdmissionEntityMapper.toEntity(admission)))
    }

}