package com.daegusw.apply.notice.jpa.adapter

import com.daegusw.apply.notice.domain.Notice
import com.daegusw.apply.notice.jpa.adapter.common.NoticeEntityMapper
import com.daegusw.apply.notice.application.port.out.persistence.CommandNoticePort
import com.daegusw.apply.notice.jpa.adapter.repository.NoticeJpaRepository
import org.springframework.stereotype.Repository

@Repository
class NoticeCommandAdapter(
    private val noticeJpaRepository: NoticeJpaRepository
) : CommandNoticePort {

    override fun save(notice: Notice): Notice {
        return NoticeEntityMapper.toDomain(
            noticeJpaRepository.save(
                NoticeEntityMapper.toEntity(notice)
            )
        ) ?: throw RuntimeException()
    }

    override fun delete(notice: Notice) {
        noticeJpaRepository.delete(
            NoticeEntityMapper.toEntity(notice)
        )
    }
}