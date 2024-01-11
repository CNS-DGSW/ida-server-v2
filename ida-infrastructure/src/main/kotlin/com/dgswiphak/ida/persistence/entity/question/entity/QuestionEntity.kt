package com.dgswiphak.ida.persistence.entity.question.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "question")
class QuestionEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    val title: String,

    val content: String,

    val createDate: LocalDateTime,
)