package com.daegusw.apply.admin.domain.secondary.repository

import com.daegusw.apply.admin.domain.secondary.domain.Secondary
import com.daegusw.apply.member.id.MemberId
import org.springframework.data.repository.CrudRepository

interface SecondaryRepository : CrudRepository<Secondary, MemberId> {
    fun findByMemberId(id: MemberId): Secondary
}