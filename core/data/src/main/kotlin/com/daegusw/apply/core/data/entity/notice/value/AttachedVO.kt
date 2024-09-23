package com.daegusw.apply.core.data.entity.notice.value

import javax.persistence.*

@Embeddable
class AttachedVO(
    val originalName: String,
    val filePath: String
)