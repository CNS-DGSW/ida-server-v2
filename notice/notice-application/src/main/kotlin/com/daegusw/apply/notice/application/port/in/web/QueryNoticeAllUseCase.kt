package com.daegusw.apply.notice.application.port.`in`.web

import com.dgswiphak.ida.domain.notice.model.Notice


interface QueryNoticeAllUseCase {

    fun queryNoticeAll(): List<Notice>
}