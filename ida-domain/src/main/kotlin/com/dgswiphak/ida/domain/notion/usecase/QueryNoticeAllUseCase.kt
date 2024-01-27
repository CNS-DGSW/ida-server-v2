package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.notion.dto.response.NoticeResponse
import com.dgswiphak.ida.domain.notion.dto.response.NoticesResponse
import com.dgswiphak.ida.domain.notion.spi.query.QueryNoticeSpi

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