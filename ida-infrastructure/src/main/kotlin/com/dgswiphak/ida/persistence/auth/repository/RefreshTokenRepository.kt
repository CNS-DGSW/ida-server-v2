package com.dgswiphak.ida.persistence.auth.repository

import com.dgswiphak.ida.persistence.auth.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
}