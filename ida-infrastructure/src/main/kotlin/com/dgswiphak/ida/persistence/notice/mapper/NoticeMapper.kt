package com.dgswiphak.ida.persistence.notice.mapper

import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.domain.notice.model.Notice
import com.dgswiphak.ida.domain.notice.model.value.Attached
import com.dgswiphak.ida.persistence.notice.entity.NoticeEntity
import com.dgswiphak.ida.persistence.notice.entity.value.AttachedVO
import org.springframework.stereotype.Component

@Component
class NoticeMapper: Mapper<Notice, NoticeEntity> {

    private val attachedMapper = AttachedMapper()

    override fun toDomain(entity: NoticeEntity?): Notice? {
        return entity?.let {
            Notice(
                id = it.id,
                title = it.title,
                content = it.content,
                isMajor = it.isMajor,
                createdDate = it.createdDate,
                attached = attachedMapper.toDomain(it.attachedVO)
            )
        }
    }

    override fun toEntity(domain: Notice): NoticeEntity {
        return NoticeEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            isMajor = domain.isMajor,
            attachedVO = domain.attached?.let { attachedMapper.toEntity(it) }
        )
    }

    inner class AttachedMapper : Mapper<List<Attached>, List<AttachedVO>> {

        override fun toDomain(entity: List<AttachedVO>?): List<Attached>? {
            return entity?.map { vo ->
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
}