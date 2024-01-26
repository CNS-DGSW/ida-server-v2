package com.dgswiphak.ida.domain.question.model

import java.time.LocalDateTime

data class Question(

    val id: Long? = null,
    
    val title: String,

    val content: String,

    val createdAt: LocalDateTime,

    val updatedAt: LocalDateTime

)