package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.notion.spi.query.CommandNoticeSpi
import com.dgswiphak.ida.domain.notion.spi.query.QueryNoticeSpi
import java.lang.RuntimeException

@UseCase
class DeleteNoticeUseCase(
    private val queryNoticeSpi: QueryNoticeSpi,
    private val commandNoticeSpi: CommandNoticeSpi
) {

    fun execute(noticeId: Long) {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw RuntimeException()

        commandNoticeSpi.delete(notice)
    }
}