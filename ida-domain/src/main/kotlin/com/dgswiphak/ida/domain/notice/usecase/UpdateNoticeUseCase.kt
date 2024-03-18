package com.dgswiphak.ida.domain.notice.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.notice.dto.request.UpdateNoticeRequest
import com.dgswiphak.ida.domain.notice.spi.query.CommandNoticeSpi
import com.dgswiphak.ida.domain.notice.spi.query.QueryNoticeSpi

@UseCase
class UpdateNoticeUseCase(
    private val queryNoticeSpi: QueryNoticeSpi,
    private val commandNoticeSpi: CommandNoticeSpi
) {

    fun execute(noticeId: Long, request: UpdateNoticeRequest) {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw RuntimeException()

        commandNoticeSpi.save(
            notice.copy(
                title = request.title,
                content = request.content,
                isMajor = request.isMajor
            )
        )
    }
}