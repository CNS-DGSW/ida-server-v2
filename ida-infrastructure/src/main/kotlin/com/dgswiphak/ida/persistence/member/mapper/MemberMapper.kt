package com.dgswiphak.ida.persistence.member.mapper

import com.dgswiphak.ida.domain.member.model.Member
import com.dgswiphak.ida.persistence.common.mapper.Mapper
import com.dgswiphak.ida.persistence.member.entity.MemberEntity
import org.springframework.stereotype.Component

@Component
class MemberMapper (
        private val idMapper: MemberIdMapper
) : Mapper<Member, MemberEntity> {
    override fun toDomain(entity: MemberEntity?): Member? {
        return entity?.let {
            Member(
                    id = idMapper.toDomain(entity.id)!!,
                    email = it.email,
                    password = it.password,
                    role = it.role
            )
        }
    }

    override fun toEntity(domain: Member): MemberEntity {
        return MemberEntity(
                id = idMapper.toEntity(domain.id),
                email = domain.email,
                password = domain.password,
                role = domain.role
        )
    }
}