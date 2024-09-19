package com.daegusw.apply.member.jpa.adapter.repository

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.entity.member.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberJpaRepository : JpaRepository<MemberEntity, EmbeddedMemberId> {
    fun existsByEmail(email: String): Boolean
}