package com.dgswiphak.ida.domain.secondary.spi.query

import com.dgswiphak.ida.domain.secondary.model.Secondary

interface CommandSecondarySpi {
    fun save(secondary: Secondary)
}