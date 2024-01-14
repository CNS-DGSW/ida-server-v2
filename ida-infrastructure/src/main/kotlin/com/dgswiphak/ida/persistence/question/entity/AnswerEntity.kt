package com.dgswiphak.ida.persistence.question.entity

import jakarta.persistence.*
import java.time.LocalTime

@Entity
@Table(name = "answer")
class AnswerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    val questionEntity: QuestionEntity,

    val content: String,

    val createDate: LocalTime
)