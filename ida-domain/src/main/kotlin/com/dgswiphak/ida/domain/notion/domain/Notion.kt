package com.dgswiphak.ida.domain.notion.domain

import java.time.LocalDateTime
import java.time.LocalTime

class Notion(

    val id: Long,

    val title: String,

    val content: String,

    val createDate: LocalDateTime

)