package com.dgswiphak.ida.persistence.applicant.entity.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serial
import java.io.Serializable

@Embeddable
class MeritVO(
    @Column(name = "merit_code")
    val code: String?
) : Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -23421337772123L

        fun of(code: String?): MeritVO {
            return MeritVO(code)
        }
    }
}