package com.dgswiphak.ida.domain.notion.domain

import java.time.LocalDateTime

class Notice(

    val id: Long,

    val title: String,

    val content: String,

    val createDate: LocalDateTime

)