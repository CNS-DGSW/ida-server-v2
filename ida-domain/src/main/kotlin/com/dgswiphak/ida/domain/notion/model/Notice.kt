package com.dgswiphak.ida.domain.notion.model

import com.dgswiphak.ida.domain.notion.model.value.Attached
import java.time.LocalDateTime

data class Notice(

    val id: Long? = null,

    val title: String,

    val content: String,

    val isMajor: Boolean,

    val createdAt: LocalDateTime,

    val attached: List<Attached>? = null
)