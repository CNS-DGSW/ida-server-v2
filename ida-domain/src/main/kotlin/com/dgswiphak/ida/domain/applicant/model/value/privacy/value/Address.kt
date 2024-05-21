package com.dgswiphak.ida.domain.applicant.model.value.privacy.value

data class Address(
    val detailAddress: String,
    val streetAddress: String,
    val zipCode: Int
) {
    init {
        if (detailAddress.isBlank()) throw IllegalArgumentException("The detailAddress cannot be empty")
        if (streetAddress.isBlank()) throw IllegalArgumentException("The streetAddress cannot be empty")
        if (zipCode < 0) throw IllegalArgumentException("The zipCode cannot be less than 0")
    }
}
