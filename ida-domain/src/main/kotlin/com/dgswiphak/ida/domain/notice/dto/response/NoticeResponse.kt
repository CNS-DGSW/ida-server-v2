package com.dgswiphak.ida.domain.notice.dto.response

import com.dgswiphak.ida.domain.notice.model.Notice
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

data class NoticeResponse(
    @field:NotNull(message = "id is required")
    val id: Long,
    @field:NotEmpty(message = "title is required")
    val title: String,

    val content: String? = null,
    @field:NotNull(message = "isMajor is required")
    val isMajor: Boolean,
    @field:NotNull(message = "createDate is required")
    val createDate: LocalDateTime,
    @field:NotNull(message = "fileResponse is required")
    val fileResponse: List<AttachedResponse>? = null
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
                createDate = notice.createdAt,
                fileResponse = notice.attached?.map {
                    AttachedResponse(
                    it.originalName,
                    it.filePath
                    )
                }
            )
        }
    }
}

data class NoticesResponse(
    val notices: List<NoticeResponse>
)

data class AttachedResponse(
    val originalName: String,
    val filePath: String
)
