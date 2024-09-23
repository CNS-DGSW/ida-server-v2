package com.daegusw.apply.applicant.domain.applicant.privacy.value

data class Address(
    val detailAddress: String,
    val streetAddress: String,
    val zipCode: Int
) {
    init {
        require(detailAddress.isNotBlank()) { throw IllegalArgumentException("The detailAddress cannot be empty") }
        require(streetAddress.isNotBlank()) { throw IllegalArgumentException("The streetAddress cannot be empty") }
    }
}
