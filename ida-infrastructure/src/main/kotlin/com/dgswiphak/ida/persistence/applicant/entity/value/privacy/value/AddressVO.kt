package com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class AddressVO(
    @Column()
    val detailAddress: String,

    @Column
    val streetAddress: String,

    @Column
    val zipCode: Int
)