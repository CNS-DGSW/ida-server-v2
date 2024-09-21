package com.daegusw.apply.notice.application.port.out.persistence

import com.daegusw.apply.notice.domain.Notice

interface QueryNoticePort {

    fun findById(noticeId: Long): Notice?

    fun findAll(): List<Notice>
}