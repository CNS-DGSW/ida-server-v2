package com.dgswiphak.ida.domain.question.spi.query

import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.question.model.Question

interface QueryQuestionSpi: QuerySpi<Question, Long> {

    override fun findById(id: Long): Question?

    fun findAll(): List<Question>
}