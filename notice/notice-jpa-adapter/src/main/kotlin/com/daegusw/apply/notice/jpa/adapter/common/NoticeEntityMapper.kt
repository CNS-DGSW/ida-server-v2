package com.daegusw.apply.notice.jpa.adapter.common

import com.dgswiphak.ida.domain.notice.model.Notice
import com.dgswiphak.ida.persistence.notice.entity.NoticeEntity
import org.springframework.stereotype.Component

@Component
class NoticeEntityMapper {


    companion object {
        fun toDomain(entity: NoticeEntity?): Notice? {
            return entity?.let {
                Notice(
                    id = it.id,
                    title = it.title,
                    content = it.content,
                    isMajor = it.isMajor,
                    createdDate = it.createdAt,
                    attached = AttachedVOMapper.toDomain(it.attachedVO)
                )
            }
        }

        fun toEntity(domain: Notice): NoticeEntity {
            return NoticeEntity(
                id = domain.id,
                title = domain.title,
                content = domain.content,
                isMajor = domain.isMajor,
                attachedVO = domain.attached?.let { AttachedVOMapper.toEntity(it) }
            )
        }
    }
}