package com.dgswiphak.ida.persistence.school.repository

import com.dgswiphak.ida.domain.school.model.School
import com.dgswiphak.ida.domain.school.spi.query.QuerySchoolSpi
import com.dgswiphak.ida.persistence.school.entity.QSchoolEntity
import com.dgswiphak.ida.persistence.school.mapper.SchoolMapper
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QuerySchoolRepository(
    private val jpaQueryFactory: JPAQueryFactory,
    private val schoolMapper: SchoolMapper
) : QuerySchoolSpi{
    override fun findById(id: Long): School? {
        val schoolEntity = QSchoolEntity.schoolEntity
        val entity = jpaQueryFactory.selectFrom(schoolEntity)
            .where(schoolEntity.id.eq(id))
            .fetchOne()

        return schoolMapper.toDomain(entity)
    }

}