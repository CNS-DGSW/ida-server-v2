package com.dgswiphak.ida.domain.question.spi.query

import com.dgswiphak.ida.domain.question.model.Question

interface CommandQuestionSpi {

    fun save(question: Question)

    fun delete(question: Question)
}