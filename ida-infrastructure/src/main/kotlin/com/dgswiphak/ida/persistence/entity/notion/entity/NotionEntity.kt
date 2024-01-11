package com.dgswiphak.ida.persistence.entity.notion.entity

import jakarta.persistence.*
import java.time.LocalTime

@Entity
@Table(name = "notion")
class NotionEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val title: String,

    val content: String,

    val createDate: LocalTime

)