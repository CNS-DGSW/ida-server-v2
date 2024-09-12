package com.daegusw.apply.member.jpa.adapter.common

import com.daegusw.apply.core.data.entity.MemberEntity
import com.daegusw.apply.member.domain.Member

class MemberEntityMapper {
    companion object {
        fun toDomain(entity: MemberEntity?): Member? {
            return entity?.let {
                Member(
                    id = MemberIdEntityMapper.toDomain(entity.id),
                    email = it.email,
                    password = entity.password,
                    role = entity.role
                )
            }
        }

        fun toEntity(domain: Member): MemberEntity {
            return MemberEntity(
                memberId = MemberIdEntityMapper.toEntity(domain.id),
                email = domain.email,
                password = domain.password,
                role = domain.role
            )
        }
    }
}