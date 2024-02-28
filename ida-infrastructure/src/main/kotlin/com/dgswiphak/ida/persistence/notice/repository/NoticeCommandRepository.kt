package com.dgswiphak.ida.persistence.notice.repository

import com.dgswiphak.ida.domain.notion.model.Notice
import com.dgswiphak.ida.domain.notion.spi.query.CommandNoticeSpi
import com.dgswiphak.ida.persistence.notice.mapper.NoticeMapper
import org.springframework.stereotype.Repository

@Repository
class NoticeCommandRepository(
    private val noticeRepository: NoticeRepository,
    private val noticeMapper: NoticeMapper
) : CommandNoticeSpi {

    override fun save(notice: Notice): Notice {
        return noticeMapper.toDomain(
            noticeRepository.save(
                noticeMapper.toEntity(notice)
            )
        ) ?: throw RuntimeException()
    }

    override fun delete(notice: Notice) {
        noticeRepository.delete(
            noticeMapper.toEntity(notice)
        )
    }
}