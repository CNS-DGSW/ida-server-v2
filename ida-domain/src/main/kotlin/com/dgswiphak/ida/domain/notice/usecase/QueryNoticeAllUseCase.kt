package com.dgswiphak.ida.domain.notice.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.notice.dto.response.NoticeResponse
import com.dgswiphak.ida.domain.notice.dto.response.NoticesResponse
import com.dgswiphak.ida.domain.notice.spi.query.QueryNoticeSpi

@UseCase
class QueryNoticeAllUseCase(
    private val queryNoticeSpi: QueryNoticeSpi
) {

    fun execute(): NoticesResponse {
        val notices = queryNoticeSpi.findAll()

        return NoticesResponse(
            notices.map {
                NoticeResponse.of(it)
            }
        )
    }
}