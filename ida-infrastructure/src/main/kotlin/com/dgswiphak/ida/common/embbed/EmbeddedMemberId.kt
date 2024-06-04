package com.dgswiphak.ida.common.embbed

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class EmbeddedMemberId(
    @Column(name = "member_id")
    val value: Long
) {
    companion object {
        fun of(id: Long): EmbeddedMemberId {
            return EmbeddedMemberId(id)
        }
    }
}