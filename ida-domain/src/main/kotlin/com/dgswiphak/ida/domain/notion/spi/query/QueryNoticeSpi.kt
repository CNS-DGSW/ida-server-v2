package com.dgswiphak.ida.domain.notion.spi.query

import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.notion.model.Notice

interface QueryNoticeSpi: QuerySpi<Notice, Long> {

    override fun findById(id: Long): Notice?

    fun findAll(): List<Notice>
}