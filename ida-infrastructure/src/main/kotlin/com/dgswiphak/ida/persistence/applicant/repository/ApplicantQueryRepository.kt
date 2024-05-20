package com.dgswiphak.ida.persistence.applicant.repository

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.domain.Applicant
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi
import com.dgswiphak.ida.persistence.applicant.entity.QApplicantEntity
import com.dgswiphak.ida.persistence.applicant.mapper.ApplicantMapper
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ApplicantQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory,
    private val applicantMapper: ApplicantMapper
) : QueryApplicantSpi {
    override fun findById(id: MemberId): Applicant? {
        val applicantEntity = QApplicantEntity.applicantEntity
        val applicant = jpaQueryFactory.selectFrom(applicantEntity)
            .where(applicantEntity.id.value.eq(id.value))
            .fetchOne()

        return applicantMapper.toDomain(applicant)
    }

    override fun findAll(): List<Applicant> {
        val applicantEntity = QApplicantEntity.applicantEntity
        val applicant = jpaQueryFactory.selectFrom(applicantEntity)
            .fetch()

        return applicant.map {
            applicantMapper.toDomain(it)
        }
    }
}