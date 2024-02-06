package com.dgswiphak.ida.persistence.member.repository

import com.dgswiphak.ida.domain.member.model.Member
import com.dgswiphak.ida.domain.member.spi.query.CommandMemberSpi
import com.dgswiphak.ida.persistence.member.mapper.MemberMapper
import org.springframework.stereotype.Repository

@Repository
class MemberCommandRepository(
    private val memberRepository: MemberRepository,
    private val memberMapper: MemberMapper
) : CommandMemberSpi{
    override fun save(member: Member): Member {
        return memberMapper.toDomain(memberRepository.save(memberMapper.toEntity(member))) ?: throw RuntimeException()
    }
}