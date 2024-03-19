package com.dgswiphak.ida.domain.notice.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.notice.exception.NoticeNotFoundException
import com.dgswiphak.ida.domain.notice.spi.query.CommandNoticeSpi
import com.dgswiphak.ida.domain.notice.spi.query.QueryNoticeSpi

@UseCase
class DeleteNoticeUseCase(
    private val queryNoticeSpi: QueryNoticeSpi,
    private val commandNoticeSpi: CommandNoticeSpi
) {

    fun execute(noticeId: Long) {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw NoticeNotFoundException

        commandNoticeSpi.delete(notice)
    }
}