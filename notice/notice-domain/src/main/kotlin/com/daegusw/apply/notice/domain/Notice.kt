package com.daegusw.apply.notice.domain

import com.daegusw.apply.notice.domain.value.Attached
import java.time.LocalDateTime

data class Notice(

    val id: Long? = null,

    val title: String,

    val content: String,

    val isMajor: Boolean,

    val createdDate: LocalDateTime? = null,

    val attached: List<Attached>? = null
)