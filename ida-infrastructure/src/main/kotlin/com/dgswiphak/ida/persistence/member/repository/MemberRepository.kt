package com.dgswiphak.ida.persistence.member.repository

import com.dgswiphak.ida.common.identity.MemberId
import com.dgswiphak.ida.persistence.member.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<MemberEntity, MemberId> {
}