package com.daegusw.apply.notice.jpa.adapter.common

import com.daegusw.apply.core.data.entity.notice.value.AttachedVO
import com.daegusw.apply.notice.domain.value.Attached

class AttachedVOMapper {

    companion object {
        fun toDomain(entity: List<AttachedVO>?): List<Attached>? {
            return entity?.map { vo ->
                Attached(
                    vo.originalName,
                    vo.filePath
                )
            }
        }

        fun toEntity(domain: List<Attached>): List<AttachedVO> {
            return domain.map { attached ->
                AttachedVO(
                    attached.originalName,
                    attached.filePath
                )
            }
        }
    }
}