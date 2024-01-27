package com.dgswiphak.ida.domain.notion.dto.response

import com.dgswiphak.ida.domain.notion.model.Notice
import java.time.LocalDateTime

data class NoticeResponse(

    val id: Long,

    val title: String,

    val content: String? = null,

    val isMajor: Boolean,

    val createDate: LocalDateTime
) {

    companion object {
        fun of(notice: Notice): NoticeResponse {
            return NoticeResponse(
                id = notice.id!!,
                title = notice.title,
                isMajor = notice.isMajor,
                createDate = notice.createdAt
            )
        }

        fun detailOf(notice: Notice): NoticeResponse {
            return NoticeResponse(
                id = notice.id!!,
                title = notice.title,
                content = notice.content,
                isMajor = notice.isMajor,
                createDate = notice.createdAt
            )
        }
    }
}

data class NoticesResponse(
    val notices: List<NoticeResponse>
)

