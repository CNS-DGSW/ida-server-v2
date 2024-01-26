package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.notion.dto.response.NoticeResponse
import com.dgswiphak.ida.domain.notion.spi.query.QueryNoticeSpi
import java.lang.RuntimeException

@UseCase
class QueryNoticeDetailsUseCase(
    private val queryNoticeSpi: QueryNoticeSpi
) {

    fun execute(noticeId: Long): NoticeResponse {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw RuntimeException()

        return NoticeResponse.detailOf(notice)
    }

}