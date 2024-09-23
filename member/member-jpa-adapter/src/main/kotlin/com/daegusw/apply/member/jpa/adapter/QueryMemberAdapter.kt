package com.daegusw.apply.member.jpa.adapter

import com.daegusw.apply.member.domain.Member
import com.daegusw.apply.member.id.MemberId
import com.daegusw.apply.member.jpa.adapter.common.MemberEntityMapper
import com.daegusw.apply.member.jpa.adapter.common.MemberIdEntityMapper
import com.daegusw.apply.member.jpa.adapter.repository.MemberJpaRepository
import com.daegusw.apply.memnber.application.port.out.persistence.QueryMemberPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class QueryMemberAdapter(
    private val memberJpaRepository: MemberJpaRepository
) : QueryMemberPort {
    override fun findById(id: MemberId): Member? {
        return MemberEntityMapper.toDomain(memberJpaRepository.findByIdOrNull(MemberIdEntityMapper.toEntity(id)))
    }

    override fun findByEmail(email: String): Member? {
        return MemberEntityMapper.toDomain(memberJpaRepository.findByEmail(email))
    }

    override fun existsByEmail(email: String): Boolean {
        return memberJpaRepository.existsByEmail(email)
    }
}