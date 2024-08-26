package com.dgswiphak.ida.domain.admission.score.spi.query

import com.dgswiphak.ida.domain.admission.score.model.Score

interface CommandScoreSpi {
    fun save(score: Score)
}
