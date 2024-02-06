package com.dgswiphak.ida.domain.auth.spi.query

import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.auth.model.RefreshToken

interface QueryRefreshTokenSpi: QuerySpi<RefreshToken, String> {
    override fun findById(id: String): RefreshToken?
}