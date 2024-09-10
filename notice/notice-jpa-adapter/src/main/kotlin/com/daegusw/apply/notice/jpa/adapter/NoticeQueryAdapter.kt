package com.daegusw.apply.notice.jpa.adapter


import com.daegusw.apply.notice.application.port.out.persistence.QueryNoticePort
import com.daegusw.apply.notice.jpa.adapter.common.NoticeEntityMapper
import com.daegusw.apply.notice.jpa.adapter.repository.NoticeJpaRepository
import com.dgswiphak.ida.domain.notice.model.Notice
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class NoticeQueryAdapter(
    private val noticeJpaRepository: NoticeJpaRepository,
): QueryNoticePort {

    override fun findById(noticeId: Long): Notice? {
        return NoticeEntityMapper.toDomain(noticeJpaRepository.findByIdOrNull(noticeId))
    }

    override fun findAll(): List<Notice> {
        val entity = noticeJpaRepository.findAll()

        return entity.map {
            NoticeEntityMapper.toDomain(it)!!
        }
    }
}