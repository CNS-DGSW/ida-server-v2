package com.daegusw.apply.notice.application.service

import com.daegusw.apply.notice.application.common.NoticeCommand
import com.daegusw.apply.notice.application.exception.NoticeNotFoundException
import com.daegusw.apply.notice.application.port.`in`.web.UpdateNoticeUseCase
import com.daegusw.apply.notice.application.port.out.persistence.QueryNoticePort
import com.daegusw.apply.notice.application.port.out.persistence.CommandNoticePort
import org.springframework.stereotype.Service

@Service
class UpdateNoticeService(
    private val queryNoticePort: QueryNoticePort,
    private val commandNoticePort: CommandNoticePort
) : UpdateNoticeUseCase {

    override fun updateNotice(noticeId: Long, command: NoticeCommand) {
        val notice = queryNoticePort.findById(noticeId)
            ?: throw NoticeNotFoundException("해당 게시글이 존재 하지 않습니다.")

        commandNoticePort.save(
            notice.copy(
                title = command.title,
                content = command.content,
                isMajor = command.isMajor
            )
        )
    }
}