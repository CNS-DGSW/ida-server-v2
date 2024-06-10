package com.dgswiphak.ida.persistence.question.entity

import com.dgswiphak.ida.persistence.BaseTimeEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "question")
class QuestionEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,

    val content: String
) : BaseTimeEntity()