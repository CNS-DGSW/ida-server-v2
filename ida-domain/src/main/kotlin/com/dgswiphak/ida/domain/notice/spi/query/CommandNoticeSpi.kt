package com.dgswiphak.ida.domain.notice.spi.query

import com.dgswiphak.ida.domain.notice.model.Notice

interface CommandNoticeSpi {

    fun save(notice: Notice): Notice

    fun delete(notice: Notice)

}