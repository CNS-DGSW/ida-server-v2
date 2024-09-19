package com.daegusw.apply.notice.application.port.`in`.web

import com.daegusw.apply.notice.application.common.NoticeCommand
import com.dgswiphak.ida.domain.notice.model.Notice

interface CreateNoticeUseCase {
    fun createNotice(noticeCommand: NoticeCommand): Notice
}