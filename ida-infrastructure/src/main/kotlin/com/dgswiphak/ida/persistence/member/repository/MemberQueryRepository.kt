package com.dgswiphak.ida.persistence.member.repository

import com.dgswiphak.ida.common.identity.MemberId
import com.dgswiphak.ida.domain.member.model.Member
import com.dgswiphak.ida.domain.member.spi.query.QueryMemberSpi
import com.dgswiphak.ida.persistence.entity.member.entity.QMemberEntity
import com.dgswiphak.ida.persistence.member.mapper.MemberMapper
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class MemberQueryRepository(
        private val jpaQueryFactory: JPAQueryFactory,
        private val memberMapper: MemberMapper
) : QueryMemberSpi  {
    override fun findById(id: MemberId): Member? {
        val memberEntity = QMemberEntity.memberEntity
        val member = jpaQueryFactory.selectFrom(memberEntity)
                    .where(memberEntity.id.id.eq(id.id))
                .fetchOne()

        return memberMapper.toDomain(member)
    }

    override fun findByEmail(email: String): Member? {
        val memberEntity = QMemberEntity.memberEntity
        val member = jpaQueryFactory.selectFrom(memberEntity)
                .where(memberEntity.email.eq(email))
                .fetchOne()

        return memberMapper.toDomain(member)
    }

}