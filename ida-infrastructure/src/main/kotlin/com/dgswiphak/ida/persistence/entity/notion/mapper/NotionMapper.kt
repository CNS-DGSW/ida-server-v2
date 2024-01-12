package com.dgswiphak.ida.persistence.entity.notion.mapper

import com.dgswiphak.ida.domain.notion.domain.Notice
import com.dgswiphak.ida.persistence.common.mapper.Mapper
import com.dgswiphak.ida.persistence.entity.notion.entity.NoticeEntity
import org.springframework.stereotype.Component

@Component
class NotionMapper : Mapper<Notice, NoticeEntity> {

    override fun toDomain(entity: NoticeEntity?): Notice? {
        return entity?.let {
            Notice(
                id = it.id,
                title = it.title,
                content = it.content,
                createDate = it.createDate
            )
        }
    }

    override fun toEntity(domain: Notice): NoticeEntity {
        return NoticeEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            createDate = domain.createDate
        )
    }
}