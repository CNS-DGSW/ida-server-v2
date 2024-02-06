package com.dgswiphak.ida.persistence.auth.mapper

import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.domain.auth.model.RefreshToken
import com.dgswiphak.ida.persistence.auth.entity.RefreshTokenEntity
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapper : Mapper<RefreshToken, RefreshTokenEntity> {
    override fun toDomain(entity: RefreshTokenEntity?): RefreshToken? {
        return entity?.let {
            RefreshToken(
                it.token,
                it.ttl
            )
        }
    }

    override fun toEntity(domain: RefreshToken): RefreshTokenEntity {
         return RefreshTokenEntity(
            domain.token,
            domain.ttl
        )
    }
}