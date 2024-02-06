package com.dgswiphak.ida.persistence.member.mapper

import com.dgswiphak.ida.common.identity.MemberId
import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
import com.dgswiphak.ida.common.mapper.Mapper
import org.springframework.stereotype.Component

@Component
class MemberIdMapper: Mapper<MemberId, EmbeddedMemberId> {
    override fun toDomain(entity: EmbeddedMemberId?): MemberId? {
        return entity?.let {
            MemberId(entity.id)
        }
    }

    override fun toEntity(domain: MemberId): EmbeddedMemberId {
        return EmbeddedMemberId.of(domain.id)
    }

}