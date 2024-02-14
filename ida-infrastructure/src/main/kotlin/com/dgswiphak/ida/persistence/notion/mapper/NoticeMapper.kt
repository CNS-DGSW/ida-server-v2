package com.dgswiphak.ida.persistence.notion.mapper

import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.domain.notion.model.Notice
import com.dgswiphak.ida.domain.notion.model.value.Attached
import com.dgswiphak.ida.persistence.notion.entity.NoticeEntity
import com.dgswiphak.ida.persistence.notion.entity.value.AttachedVO
import org.springframework.stereotype.Component

@Component
class NoticeMapper(
    private val fileMapper: FileMapper
) : Mapper<Notice, NoticeEntity> {

    override fun toDomain(entity: NoticeEntity?): Notice? {
        return entity?.let {
            Notice(
                id = it.id,
                title = it.title,
                content = it.content,
                isMajor = it.isMajor,
                createdAt = it.createdAt,
                attached = fileMapper.toDomain(it.attachedVO)
            )
        }
    }

    override fun toEntity(domain: Notice): NoticeEntity {
        return NoticeEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            isMajor = domain.isMajor,
            createdAt = domain.createdAt,
            attachedVO = fileMapper.toEntity(domain.attached)
        )
    }
}

@Component
class FileMapper : Mapper<List<Attached>, List<AttachedVO>> {

    override fun toDomain(entity: List<AttachedVO>?): List<Attached> {
        return entity!!.map { vo ->
            Attached(
                vo.originalName,
                vo.filePath
            )
        }

    }

    override fun toEntity(domain: List<Attached>): List<AttachedVO> {
        return domain.map { attached ->
            AttachedVO(
                attached.originalName,
                attached.filePath
            )
        }
    }
}