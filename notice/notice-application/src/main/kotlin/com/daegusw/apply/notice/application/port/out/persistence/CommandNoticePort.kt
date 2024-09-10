package com.daegusw.apply.notice.application.port.out.persistence

import com.dgswiphak.ida.domain.notice.model.Notice

interface CommandNoticePort {

    fun save(notice: Notice): Notice

    fun delete(notice: Notice)

}