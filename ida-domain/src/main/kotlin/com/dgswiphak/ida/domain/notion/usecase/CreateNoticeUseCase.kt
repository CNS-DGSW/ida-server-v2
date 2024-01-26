package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.notion.dto.request.CreateNoticeRequest
import com.dgswiphak.ida.domain.notion.model.Notice
import com.dgswiphak.ida.domain.notion.spi.query.CommandNoticeSpi
import java.time.LocalDateTime

@UseCase
class CreateNoticeUseCase(
   private val commandNoticeSpi: CommandNoticeSpi
) {

    fun execute(request: CreateNoticeRequest) {

        val notice = Notice(
            title = request.title,
            content = request.content,
            isMajor = request.isMajor,
            createdAt = LocalDateTime.now(),
        )

        commandNoticeSpi.save(notice)
    }
}