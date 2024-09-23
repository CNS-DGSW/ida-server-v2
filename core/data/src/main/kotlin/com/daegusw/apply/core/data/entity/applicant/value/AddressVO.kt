package com.daegusw.apply.core.data.entity.applicant.value

import javax.persistence.Embeddable

@Embeddable
data class AddressVO(
    val detailAddress: String,

    val streetAddress: String,

    val zipCode: Int
)