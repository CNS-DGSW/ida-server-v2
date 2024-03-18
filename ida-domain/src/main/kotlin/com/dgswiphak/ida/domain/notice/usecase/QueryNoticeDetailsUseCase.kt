package com.dgswiphak.ida.domain.notice.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.notice.dto.response.NoticeResponse
import com.dgswiphak.ida.domain.notice.spi.query.QueryNoticeSpi
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