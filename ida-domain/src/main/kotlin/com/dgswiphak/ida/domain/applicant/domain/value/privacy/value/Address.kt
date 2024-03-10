package com.dgswiphak.ida.domain.applicant.domain.value.privacy.value

data class Address(
    val detailAddress: String,
    val streetAddress: String,
    val zipCode: Int? = -1
)
