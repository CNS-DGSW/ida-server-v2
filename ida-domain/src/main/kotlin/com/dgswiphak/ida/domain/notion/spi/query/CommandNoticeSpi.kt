package com.dgswiphak.ida.domain.notion.spi.query

import com.dgswiphak.ida.domain.notion.model.Notice

interface CommandNoticeSpi {

    fun save(notice: Notice)

    fun delete(notice: Notice)

}