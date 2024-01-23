package com.dgswiphak.ida.domain.question.model

import java.time.LocalDateTime

data class Question(

    val id: Int,
    
    val title: String,

    val createDate: LocalDateTime,

    val content: String
)