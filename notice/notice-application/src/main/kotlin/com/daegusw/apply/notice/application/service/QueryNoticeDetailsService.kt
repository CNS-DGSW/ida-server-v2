package com.daegusw.apply.notice.application.service

import com.daegusw.apply.notice.application.exception.NoticeNotFoundException
import com.daegusw.apply.notice.application.port.`in`.web.QueryNoticeDetailsUseCase
import com.daegusw.apply.notice.application.port.out.persistence.QueryNoticePort
import com.daegusw.apply.notice.domain.Notice
import org.springframework.stereotype.Service

@Service
class QueryNoticeDetailsService(
    private val queryNoticePort: QueryNoticePort
) : QueryNoticeDetailsUseCase {

    override fun queryNoticeDerails(noticeId: Long): Notice {
        return queryNoticePort.findById(noticeId)
            ?: throw NoticeNotFoundException("해당 게시글이 존재 하지 않습니다.")
    }
}