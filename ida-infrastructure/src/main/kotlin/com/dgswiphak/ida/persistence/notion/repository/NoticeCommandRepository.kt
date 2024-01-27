package com.dgswiphak.ida.persistence.notion.repository

import com.dgswiphak.ida.domain.notion.model.Notice
import com.dgswiphak.ida.domain.notion.spi.query.CommandNoticeSpi
import com.dgswiphak.ida.persistence.notion.mapper.NoticeMapper
import org.springframework.stereotype.Repository

@Repository
class NoticeCommandRepository(
    private val noticeRepository: NoticeRepository,
    private val noticeMapper: NoticeMapper
) : CommandNoticeSpi {

    override fun save(notice: Notice) {
        noticeRepository.save(
            noticeMapper.toEntity(notice)
        )
    }

    override fun delete(notice: Notice) {
        noticeRepository.delete(
            noticeMapper.toEntity(notice)
        )
    }
}