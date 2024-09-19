package com.daegusw.apply.admission.jpa.adapter

import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.admission.jpa.adapter.common.AdmissionEntityMapper
import com.daegusw.apply.admission.jpa.adapter.repository.AdmissionJpaRepository
import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.member.id.MemberId

class AdmissionQueryAdapter(
    private val admissionJpaRepository: AdmissionJpaRepository
) : QueryAdmissionPort {
    override fun findByMemberId(id: MemberId): Admission? {
        return AdmissionEntityMapper.toDomain(admissionJpaRepository.findByApplicant_Member(EmbeddedMemberId.of(id)))
    }
}