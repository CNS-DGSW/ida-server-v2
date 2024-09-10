package com.dgswiphak.ida.persistence.notice.entity

import com.daegusw.apply.core.data.common.TimeBaseEntity
import com.daegusw.apply.core.data.entity.notice.value.AttachedVO
import javax.persistence.*

@Entity
@Table(name = "notice")
class NoticeEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String,

    val content: String,

    val isMajor: Boolean,

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "notice_attached")
    val attachedVO: List<AttachedVO>? = null
) : TimeBaseEntity()