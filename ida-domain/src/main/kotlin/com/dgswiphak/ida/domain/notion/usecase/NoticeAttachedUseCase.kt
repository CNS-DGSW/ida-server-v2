package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.file.FileService
import com.dgswiphak.ida.domain.notion.model.value.Attached
import com.dgswiphak.ida.domain.notion.spi.query.CommandNoticeSpi
import com.dgswiphak.ida.domain.notion.spi.query.QueryNoticeSpi
import org.springframework.core.io.Resource

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

        val attached = request.map {
            Attached(
                originalName = it.filename,
                filePath = fileService.save(
                    FILE_DIR,
                    it
                )
            )
        }

        commandNoticeSpi.save(
            notice.copy(
                attached = attached
            )
        )
    }

    fun download(
        noticeId: Long,
        fileName: String
    ): Resource {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw RuntimeException()

        val attached = notice.attached!!.firstOrNull {
            it.originalName == fileName
        } ?: throw RuntimeException()

        return fileService.read(attached.filePath)
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

    companion object {
        const val FILE_DIR = "static/notice/file"
    }
}