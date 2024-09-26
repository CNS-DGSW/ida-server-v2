package com.daegusw.apply.member.jpa.adapter.common

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.member.id.MemberId

class MemberIdEntityMapper {
    companion object {
        fun toDomain(entity: EmbeddedMemberId): MemberId {
            return MemberId(
                entity.id
            )
        }

        fun toEntity(domain: MemberId): EmbeddedMemberId {
            return EmbeddedMemberId(
                domain.value
            )
        }
    }
}