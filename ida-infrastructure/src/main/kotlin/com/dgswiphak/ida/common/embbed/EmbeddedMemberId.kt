package com.dgswiphak.ida.common.embbed

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class EmbeddedMemberId(
    @Column(name = "member_id")
    val value: Long
): Serializable {
    companion object {
        private const val serialVersionUID: Long = -7305105972131878927L

        fun of(id: Long): EmbeddedMemberId {
            return EmbeddedMemberId(id)
        }
    }
}