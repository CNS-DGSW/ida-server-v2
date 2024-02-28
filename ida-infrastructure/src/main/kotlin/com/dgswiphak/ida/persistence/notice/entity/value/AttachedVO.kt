package com.dgswiphak.ida.persistence.notice.entity.value

import jakarta.persistence.Embeddable
import java.io.Serial
import java.io.Serializable

@Embeddable
class AttachedVO(
    val originalName: String,
    val filePath: String
): Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -4349777962618637774L
    }
}