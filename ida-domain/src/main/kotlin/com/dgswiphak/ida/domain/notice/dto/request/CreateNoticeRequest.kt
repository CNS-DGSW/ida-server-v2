package com.dgswiphak.ida.domain.notice.dto.request

data class CreateNoticeRequest(

    val title: String,

    val content: String,

    val isMajor: Boolean
)