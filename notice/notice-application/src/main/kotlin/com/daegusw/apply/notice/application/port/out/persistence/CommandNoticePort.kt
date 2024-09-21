package com.daegusw.apply.notice.application.port.out.persistence

import com.daegusw.apply.notice.domain.Notice

interface CommandNoticePort {

    fun save(notice: Notice): Notice

    fun delete(notice: Notice)

}