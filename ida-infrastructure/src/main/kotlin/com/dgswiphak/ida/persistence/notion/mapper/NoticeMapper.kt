package com.dgswiphak.ida.persistence.notion.mapper

import com.dgswiphak.ida.domain.notion.model.Notice
import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.persistence.notion.entity.NoticeEntity
import org.springframework.stereotype.Component

@Component
class NoticeMapper : Mapper<Notice, NoticeEntity> {

    override fun toDomain(entity: NoticeEntity?): Notice? {
        return entity?.let {
            Notice(
                id = it.id,
                title = it.title,
                content = it.content,
                isMajor = it.isMajor,
                createdAt = it.createdAt
            )
        }
    }

    override fun toEntity(domain: Notice): NoticeEntity {
        return NoticeEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            isMajor = domain.isMajor,
            createdAt = domain.createdAt
        )
    }
}