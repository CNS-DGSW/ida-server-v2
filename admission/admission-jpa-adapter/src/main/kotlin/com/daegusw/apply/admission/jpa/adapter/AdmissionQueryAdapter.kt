package com.daegusw.apply.admission.jpa.adapter

import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.admission.jpa.adapter.common.AdmissionEntityMapper
import com.daegusw.apply.admission.jpa.adapter.repository.AdmissionJpaRepository
import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Repository

@Repository
class AdmissionQueryAdapter(
    private val admissionJpaRepository: AdmissionJpaRepository
) : QueryAdmissionPort {
    override fun findByMemberId(id: MemberId): Admission? {
        return AdmissionEntityMapper.toDomain(admissionJpaRepository.findByApplicantMember(EmbeddedMemberId.of(id)))
    }

    override fun findAll(): List<Admission> {
        return admissionJpaRepository.findAll().map {
            AdmissionEntityMapper.toDomain(it)!!
        }
    }

    override fun findAllByProgress(progress: Progress): List<Admission> {
        return admissionJpaRepository.findAllByProgress(progress).map {
            AdmissionEntityMapper.toDomain(it)!!
        }
    }

}