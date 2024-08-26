package com.dgswiphak.ida.persistence.admission.admission.repository

import com.dgswiphak.ida.domain.admission.admission.model.Admission
import com.dgswiphak.ida.domain.admission.admission.spi.QueryAdmissionSpi
import com.dgswiphak.ida.persistence.admission.admission.entity.QAdmissionEntity
import com.dgswiphak.ida.persistence.admission.admission.mapper.AdmissionMapper
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class AdmissionQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory,
    private val admissionMapper: AdmissionMapper
) : QueryAdmissionSpi{
    override fun findById(id: Long): Admission? {
        val admissionEntity = QAdmissionEntity.admissionEntity
        val admission = jpaQueryFactory.selectFrom(admissionEntity)
            .where(admissionEntity.applicant.memberId.value.eq(id))
            .fetchOne()

        return admissionMapper.toDomain(admission)
    }
}
