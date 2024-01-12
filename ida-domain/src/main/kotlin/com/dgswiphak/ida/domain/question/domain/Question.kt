package com.dgswiphak.ida.domain.question.domain

import java.time.LocalDateTime

class Question(

    val id: Int,
    
    val title: String,

    val createDate: LocalDateTime,

    val content: String
)