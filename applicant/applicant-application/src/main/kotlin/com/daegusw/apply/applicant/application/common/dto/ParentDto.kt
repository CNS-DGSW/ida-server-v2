package com.daegusw.apply.applicant.application.common.dto

import com.daegusw.apply.applicant.domain.applicant.privacy.value.Address
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Parent
import java.time.LocalDate

data class ParentDto(
    val name: String,
    val relation: String,
    val phone: String,
    val birth: LocalDate,
    val streetAddress: String,
    val detailAddress: String,
    val zipCode: Int,
) {
    constructor(parent: Parent?, address: Address?): this(
        name = parent?.name ?: "",
        relation = parent?.relation ?: "",
        phone = parent?.phone ?: "",
        birth = parent?.birth ?: LocalDate.now(),
        streetAddress = address?.streetAddress ?: "",
        detailAddress = address?.detailAddress ?: "",
        zipCode = address?.zipCode ?: 0
    )

    fun toParent() = Parent(
        name = name,
        relation = relation,
        phone = phone,
        birth = birth,
    )

    fun toAddress() = Address(
        detailAddress = detailAddress,
        streetAddress = streetAddress,
        zipCode = zipCode
    )
}
