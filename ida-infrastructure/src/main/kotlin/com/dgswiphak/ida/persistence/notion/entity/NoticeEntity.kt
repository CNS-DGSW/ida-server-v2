package com.dgswiphak.ida.persistence.notion.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "notice")
class NoticeEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,

    val content: String,

    val isMajor: Boolean,

    val createdAt: LocalDateTime
)