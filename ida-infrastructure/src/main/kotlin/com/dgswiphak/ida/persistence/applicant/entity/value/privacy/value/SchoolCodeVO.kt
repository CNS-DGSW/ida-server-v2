package com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serial
import java.io.Serializable

@Embeddable
class SchoolCodeVO(
    @Column(name = "school_code")
    val code: String?
) : Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -28371923787
        fun of(code: String?): SchoolCodeVO {
            return SchoolCodeVO(code)
        }
    }
}