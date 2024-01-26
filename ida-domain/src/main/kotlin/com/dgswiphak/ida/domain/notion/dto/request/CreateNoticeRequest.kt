package com.dgswiphak.ida.domain.notion.dto.request

data class CreateNoticeRequest(

    val title: String,

    val content: String,

    val isMajor: Boolean
)