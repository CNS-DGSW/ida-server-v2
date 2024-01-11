package com.dgswiphak.ida.domain.question.domain

import java.time.LocalTime

class Answer(
    val id: Long,

    val question: Question,

    val content: String,

    val createDate: LocalTime
)