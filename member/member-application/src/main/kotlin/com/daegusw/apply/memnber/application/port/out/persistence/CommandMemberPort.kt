package com.daegusw.apply.memnber.application.port.out.persistence

import com.daegusw.apply.member.domain.Member

interface CommandMemberPort {
    fun saveMember(member: Member)
}