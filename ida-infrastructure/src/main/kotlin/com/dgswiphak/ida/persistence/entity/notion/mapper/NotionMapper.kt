package com.dgswiphak.ida.persistence.entity.notion.mapper

import com.dgswiphak.ida.domain.notion.domain.Notion
import com.dgswiphak.ida.persistence.common.mapper.Mapper
import com.dgswiphak.ida.persistence.entity.notion.entity.NotionEntity

class NotionMapper : Mapper<Notion, NotionEntity> {

    override fun toDomain(entity: NotionEntity?): Notion? {
        return entity?.let {
            Notion(
                id = it.id,
                title = it.title,
                content = it.content,
                createDate = it.createDate
            )
        }
    }

    override fun toEntity(domain: Notion): NotionEntity {
        return NotionEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            createDate = domain.createDate
        )
    }
}