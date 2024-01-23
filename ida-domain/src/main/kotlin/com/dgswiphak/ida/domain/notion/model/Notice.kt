package com.dgswiphak.ida.domain.notion.model

import java.time.LocalDateTime

data class Notice(

    val id: Long,

    val title: String,

    val content: String,

    val createDate: LocalDateTime

)