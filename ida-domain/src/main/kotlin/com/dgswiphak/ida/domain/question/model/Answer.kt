package com.dgswiphak.ida.domain.question.model

import java.time.LocalTime

data class Answer(
    val id: Long,

    val question: Question,

    val content: String,

    val createDate: LocalTime
)