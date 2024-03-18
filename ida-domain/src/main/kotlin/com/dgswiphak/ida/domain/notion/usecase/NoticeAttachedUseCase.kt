package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.file.FileService
import com.dgswiphak.ida.domain.notion.model.value.Attached
import com.dgswiphak.ida.domain.notion.spi.query.CommandNoticeSpi
import com.dgswiphak.ida.domain.notion.spi.query.QueryNoticeSpi

@UseCase
class NoticeAttachedUseCase(
    private val fileService: FileService,
    private val queryNoticeSpi: QueryNoticeSpi,
    private val commandNoticeSpi: CommandNoticeSpi
) {

    fun save(
        noticeId: Long,
        request: List<FileRequest>
    ) {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw RuntimeException()

        var attached = notice.attached

        attached = attached?.plus(
            request.map { req ->
                Attached(
                    originalName = req.filename,
                    filePath = fileService.upload(
                        fileRequest = req
                    )
                )
            }
        )

        commandNoticeSpi.save(
            notice.copy(
                attached = attached
            )
        )
    }

    fun delete(
        noticeId: Long,
        fileName: String
    ) {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw RuntimeException()

        val mutableAttached = notice.attached!!.toMutableList()

        val attached = notice.attached.firstOrNull {
            it.originalName == fileName
        } ?: throw RuntimeException()

        mutableAttached.remove(attached)

        fileService.delete(attached.filePath)

        commandNoticeSpi.save(notice.copy(attached = mutableAttached.toList()))
    }
}