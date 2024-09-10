package com.daegusw.apply.notice.application.service

import com.daegusw.apply.notice.application.exception.NoticeNotFoundException
import com.daegusw.apply.notice.application.port.`in`.web.DeleteNoticeUseCase
import com.daegusw.apply.notice.application.port.out.persistence.QueryNoticePort
import com.daegusw.apply.notice.application.port.out.persistence.CommandNoticePort
import org.springframework.stereotype.Service

@Service
class DeleteNoticeService(
    private val queryNoticePort: QueryNoticePort,
    private val commandNoticePort: CommandNoticePort
) : DeleteNoticeUseCase {

    override fun deleteNotice(noticeId: Long) {
        val notice = queryNoticePort.findById(noticeId)
            ?: throw NoticeNotFoundException("해당 게시글이 존재 하지 않습니다.")

        commandNoticePort.delete(notice)
    }
}