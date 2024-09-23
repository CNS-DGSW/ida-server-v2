package com.daegusw.apply.memnber.application.port.out.persistence

import com.daegusw.apply.member.domain.Member
import com.daegusw.apply.member.id.MemberId

interface QueryMemberPort {
    fun findById(id: MemberId): Member?
    fun findByEmail(email: String): Member?
    fun existsByEmail(email: String): Boolean
}