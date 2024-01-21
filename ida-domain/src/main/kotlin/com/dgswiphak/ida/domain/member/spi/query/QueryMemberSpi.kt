package com.dgswiphak.ida.domain.member.spi.query

import com.dgswiphak.ida.common.identity.MemberId
import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.member.model.Member

interface QueryMemberSpi: QuerySpi<Member, MemberId> {
    override fun findById(id: MemberId): Member?

    fun findByEmail(email: String): Member?
}