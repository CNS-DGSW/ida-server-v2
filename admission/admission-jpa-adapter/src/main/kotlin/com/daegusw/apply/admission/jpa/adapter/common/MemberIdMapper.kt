package com.daegusw.apply.admission.jpa.adapter.common

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.member.id.MemberId

class MemberIdMapper {
    companion object {
        fun toEntity(id: MemberId): EmbeddedMemberId {
            return EmbeddedMemberId(id.value)
        }

        fun toDomain(id:EmbeddedMemberId): MemberId {
            return MemberId(id.value)
        }
    }
}