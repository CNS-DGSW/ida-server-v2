package com.dgswiphak.ida.persistence.secondary.repository

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.secondary.model.Secondary
import com.dgswiphak.ida.domain.secondary.spi.query.QuerySecondarySpi
import com.dgswiphak.ida.persistence.secondary.entity.QSecondaryEntity
import com.dgswiphak.ida.persistence.secondary.mapper.SecondaryMapper
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class QuerySecondaryRepository(
    private val jpaQueryFactory: JPAQueryFactory,
    private val secondaryMapper: SecondaryMapper
): QuerySecondarySpi {

    override fun findById(id: MemberId): Secondary? {
        val secondaryEntity = QSecondaryEntity.secondaryEntity
        val entity = jpaQueryFactory.selectFrom(secondaryEntity)
            .where(secondaryEntity.id.value.eq(id.value))
            .fetchOne()

        return secondaryMapper.toDomain(entity)
    }
}