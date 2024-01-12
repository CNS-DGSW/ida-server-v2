package com.dgswiphak.ida.persistence.entity.notion.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "notice")
class NoticeEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val title: String,

    val content: String,

    val createDate: LocalDateTime

)