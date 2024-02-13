package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.file.FileService
import com.dgswiphak.ida.domain.notion.spi.query.QueryNoticeSpi
import org.springframework.core.io.Resource

@UseCase
class AttachedDownloadUseCase(
    private val fileService: FileService,
    private val queryNoticeSpi: QueryNoticeSpi
) {

    fun execute(
        noticeId: Long,
        fileName: String
    ): Resource {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw RuntimeException()

        val attached = notice.attached.firstOrNull {
            it.originalName == fileName
        }?: throw RuntimeException()

        return fileService.download(attached.filePath)
    }
}