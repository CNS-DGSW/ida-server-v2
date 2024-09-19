package com.daegusw.apply.notice.application.port.`in`.web

import com.dgswiphak.ida.domain.notice.model.Notice


interface QueryNoticeDetailsUseCase {

    fun queryNoticeDerails(noticeId: Long): Notice

}