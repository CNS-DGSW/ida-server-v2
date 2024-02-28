package com.dgswiphak.ida.persistence.notice.repository


import com.dgswiphak.ida.domain.notion.model.Notice
import com.dgswiphak.ida.domain.notion.spi.query.QueryNoticeSpi
import com.dgswiphak.ida.persistence.notice.entity.QNoticeEntity
import com.dgswiphak.ida.persistence.notice.mapper.NoticeMapper
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class NoticeQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory,
    private val noticeMapper: NoticeMapper
): QueryNoticeSpi {

    override fun findById(id: Long): Notice? {
        val noticeEntity = QNoticeEntity.noticeEntity
        val entity = jpaQueryFactory.selectFrom(noticeEntity)
            .where(noticeEntity.id.eq(id))
            .fetchOne()

        return noticeMapper.toDomain(entity)
    }

    override fun findAll(): List<Notice> {
        val noticeEntity = QNoticeEntity.noticeEntity
        val entity = jpaQueryFactory.selectFrom(noticeEntity)
            .orderBy(
                noticeEntity.isMajor.desc(),
                noticeEntity.createdAt.desc()
            )
            .fetch()

        return entity.map {
            noticeMapper.toDomain(it)!!
        }
    }
}