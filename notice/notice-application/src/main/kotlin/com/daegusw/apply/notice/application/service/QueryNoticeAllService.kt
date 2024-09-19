package com.daegusw.apply.notice.application.service

import com.daegusw.apply.notice.application.port.`in`.web.QueryNoticeAllUseCase
import com.daegusw.apply.notice.application.port.out.persistence.QueryNoticePort
import com.dgswiphak.ida.domain.notice.model.Notice
import org.springframework.stereotype.Service

@Service
class QueryNoticeAllService(
    private val queryNoticeSpi: QueryNoticePort
) : QueryNoticeAllUseCase {

    override fun queryNoticeAll(): List<Notice> {
        return queryNoticeSpi.findAll()
    }
}