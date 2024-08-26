package com.dgswiphak.ida.domain.admission.score.spi.query

import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.admission.score.model.Score

interface QueryScoreSpi: QuerySpi<Score, Long> {
    override fun findById(id: Long): Score?
}