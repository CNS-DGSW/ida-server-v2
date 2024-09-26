package com.daegusw.apply.core.data.common

import com.daegusw.apply.member.id.MemberId
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class EmbeddedMemberId(
    @Column(name = "member_id")
    val id: Long
): Serializable {
    companion object {
        fun of(id: MemberId) = EmbeddedMemberId(id.value)
    }

}