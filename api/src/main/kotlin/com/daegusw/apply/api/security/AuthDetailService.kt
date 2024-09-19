package com.daegusw.apply.api.security

import com.daegusw.apply.member.domain.Member
import com.daegusw.apply.member.id.MemberId
import com.daegusw.apply.memnber.application.port.out.persistence.QueryMemberPort
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailService (
    private val queryMemberPort: QueryMemberPort
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val id = username.toLong()
        val member = queryMemberPort.findById(MemberId(id)) ?: throw RuntimeException()
        return toUserDetails(member)
    }

    private fun toUserDetails(member: Member): UserDetails {
        return AuthUser(
            member.id,
            member.email,
            member.password.value,
            toGrantedAuthorities(member.role)
        )
    }

    fun toGrantedAuthorities(role: Enum<*>): MutableCollection<GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(role.name))
    }
}