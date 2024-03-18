package com.dgswiphak.ida.domain.notice.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.notice.dto.request.CreateNoticeRequest
import com.dgswiphak.ida.domain.notice.model.Notice
import com.dgswiphak.ida.domain.notice.spi.query.CommandNoticeSpi
import java.time.LocalDateTime

@UseCase
class CreateNoticeUseCase(
    private val commandNoticeSpi: CommandNoticeSpi,
) {

    fun execute(request: CreateNoticeRequest): Notice {

        val notice = Notice(
            title = request.title,
            content = request.content,
            isMajor = request.isMajor,
            createdAt = LocalDateTime.now()
        )

        return commandNoticeSpi.save(notice)
    }
}