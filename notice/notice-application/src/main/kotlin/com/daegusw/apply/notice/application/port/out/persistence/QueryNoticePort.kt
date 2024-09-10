package com.daegusw.apply.notice.application.port.out.persistence

import com.dgswiphak.ida.domain.notice.model.Notice

interface QueryNoticePort {

    fun findById(noticeId: Long): Notice?

    fun findAll(): List<Notice>
}