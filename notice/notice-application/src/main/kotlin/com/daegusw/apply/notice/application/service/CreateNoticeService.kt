package com.daegusw.apply.notice.application.service

import com.daegusw.apply.notice.application.common.NoticeCommand
import com.daegusw.apply.notice.application.port.`in`.web.CreateNoticeUseCase
import com.daegusw.apply.notice.domain.Notice
import com.daegusw.apply.notice.application.port.out.persistence.CommandNoticePort
import org.springframework.stereotype.Service

@Service
class CreateNoticeService(
    private val commandNoticePort: CommandNoticePort,
): CreateNoticeUseCase {

    override fun createNotice(noticeCommand: NoticeCommand): Notice {

        val notice = Notice(
            title = noticeCommand.title,
            content = noticeCommand.content,
            isMajor = noticeCommand.isMajor
        )

        return commandNoticePort.save(notice)
    }
}