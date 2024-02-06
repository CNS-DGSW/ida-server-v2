package com.dgswiphak.ida.domain.auth.spi.query

import com.dgswiphak.ida.domain.auth.model.RefreshToken

interface CommandRefreshTokenSpi {
    fun save(refreshToken: RefreshToken)
}