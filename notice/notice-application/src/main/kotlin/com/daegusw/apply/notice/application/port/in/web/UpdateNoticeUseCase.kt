package com.daegusw.apply.notice.application.port.`in`.web

import com.daegusw.apply.notice.application.common.NoticeCommand


interface UpdateNoticeUseCase {

    fun updateNotice(noticeId: Long, command: NoticeCommand)
}