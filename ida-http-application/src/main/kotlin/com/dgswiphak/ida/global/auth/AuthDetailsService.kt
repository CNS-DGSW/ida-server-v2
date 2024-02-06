package com.dgswiphak.ida.global.auth

import com.dgswiphak.ida.common.identity.MemberId
import com.dgswiphak.ida.domain.member.spi.query.QueryMemberSpi
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
        private val queryMemberSpi: QueryMemberSpi
) : UserDetailsService {
    override fun loadUserByUsername(memberId: String): UserDetails {
        val member = queryMemberSpi.findById(MemberId(memberId.toLong())) ?: throw RuntimeException()
        return AuthDetails(member)
    }
}