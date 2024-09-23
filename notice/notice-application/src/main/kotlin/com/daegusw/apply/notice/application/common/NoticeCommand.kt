package com.daegusw.apply.notice.application.common

data class NoticeCommand(
    val title: String,
    val content: String,
    val isMajor: Boolean
)