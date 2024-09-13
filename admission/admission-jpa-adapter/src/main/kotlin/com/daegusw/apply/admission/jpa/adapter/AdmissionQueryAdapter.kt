package com.daegusw.apply.admission.jpa.adapter

import com.daegusw.apply.admission.application.QueryAdmissionPort
import com.daegusw.apply.admission.domain.Admission
import com.daegusw.apply.admission.jpa.adapter.common.AdmissionEntityMapper
import com.daegusw.apply.admission.jpa.adapter.common.MemberIdMapper
import com.daegusw.apply.admission.jpa.adapter.repository.AdmissionJpaRepository
import com.daegusw.apply.member.id.MemberId

class AdmissionQueryAdapter(
    private val admissionJpaRepository: AdmissionJpaRepository
) : QueryAdmissionPort {
    override fun findById(id: MemberId): Admission? {
        return AdmissionEntityMapper.toDomain(admissionJpaRepository.findByMemberId(MemberIdMapper.toEntity(id)))
    }
}