package com.dgswiphak.ida.persistence.applicant.entity.value

import jakarta.persistence.Embeddable
import java.io.Serial
import java.io.Serializable

@Embeddable
class AddressVO(
    val detailAddress: String,
    val streetAddress: String,
    val zipCode: Int? = -1
): Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -33412312337772123L
    }
}