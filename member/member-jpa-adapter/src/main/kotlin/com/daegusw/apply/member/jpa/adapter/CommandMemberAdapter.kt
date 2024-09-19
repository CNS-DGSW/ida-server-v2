package com.daegusw.apply.member.jpa.adapter

import com.daegusw.apply.member.domain.Member
import com.daegusw.apply.member.jpa.adapter.common.MemberEntityMapper
import com.daegusw.apply.member.jpa.adapter.repository.MemberJpaRepository
import com.daegusw.apply.memnber.application.port.out.persistence.CommandMemberPort
import org.springframework.stereotype.Repository

@Repository
class CommandMemberAdapter(
    private val memberJpaRepository: MemberJpaRepository
): CommandMemberPort {
    override fun saveMember(member: Member): Member {
        return MemberEntityMapper.toDomain(memberJpaRepository.save(MemberEntityMapper.toEntity(member)))!!
    }
}