package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.file.FileService
import com.dgswiphak.ida.domain.notion.dto.request.CreateNoticeRequest
import com.dgswiphak.ida.domain.notion.model.Notice
import com.dgswiphak.ida.domain.notion.model.value.Attached
import com.dgswiphak.ida.domain.notion.spi.query.CommandNoticeSpi
import java.time.LocalDateTime

@UseCase
class CreateNoticeUseCase(
    private val commandNoticeSpi: CommandNoticeSpi,
    private val fileService: FileService
) {

    fun execute(
        noticeRequest: CreateNoticeRequest,
        attachedRequest: List<FileRequest>
    ) {
        val attached = attachedRequest.map {
            Attached(
                originalName = it.filename,
                filePath = fileService.save(
                    "static/file",
                    it
                )
            )
        }

        val notice = Notice(
            title = noticeRequest.title,
            content = noticeRequest.content,
            isMajor = noticeRequest.isMajor,
            createdAt = LocalDateTime.now(),
            attached = attached
        )

        commandNoticeSpi.save(notice)
    }
}