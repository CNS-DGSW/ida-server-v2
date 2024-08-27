package com.dgswiphak.ida.domain.notice.model

import com.dgswiphak.ida.domain.notice.model.value.Attached
import java.time.LocalDateTime

data class Notice(

    val id: Long? = null,

    val title: String,

    val content: String,

    val isMajor: Boolean,

    val createdDate: LocalDateTime? = null,

    val attached: List<Attached>? = null
)