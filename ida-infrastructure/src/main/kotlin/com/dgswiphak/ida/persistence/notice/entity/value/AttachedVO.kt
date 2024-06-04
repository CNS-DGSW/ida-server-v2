package com.dgswiphak.ida.persistence.notice.entity.value

import jakarta.persistence.Embeddable

@Embeddable
class AttachedVO(
    val originalName: String,
    val filePath: String
)