package com.daegusw.apply.notice.application.port.`in`.web

import com.daegusw.apply.notice.domain.Notice


interface QueryNoticeAllUseCase {

    fun queryNoticeAll(): List<Notice>
}