package com.dgswiphak.ida.domain.secondary.spi.query

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.secondary.model.Secondary

interface QuerySecondarySpi: QuerySpi<Secondary, MemberId> {
    override fun findById(id: MemberId): Secondary?
}