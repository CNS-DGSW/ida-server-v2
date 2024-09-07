package com.daegusw.apply.core.data.common

import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class EmbeddedMemberId(
    @Column(name = "member_id")
    val value: Long
): Serializable {
    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null || javaClass != obj.javaClass) return false
        val embeddedMemberId = obj as EmbeddedMemberId
        return value == embeddedMemberId.value
    }

    override fun hashCode(): Int {
        return Objects.hash(value)
    }
}