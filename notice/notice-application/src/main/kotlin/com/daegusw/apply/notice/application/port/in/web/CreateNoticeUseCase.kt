package com.daegusw.apply.notice.application.port.`in`.web

import com.daegusw.apply.notice.application.common.NoticeCommand
import com.daegusw.apply.notice.domain.Notice

interface CreateNoticeUseCase {
    fun createNotice(noticeCommand: NoticeCommand): Notice
}