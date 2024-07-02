package com.dgswiphak.ida.domain.applicant.dto.request

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Address
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Parent
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class UpdateParentInfoRequest(
    val name: String,

    val relation: String,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val birth: LocalDate,

    val phone: String,

    val streetAddress: String,

    val detailAddress: String,

    val zipCode: Int
) {
    fun toParent(): Parent {
        return Parent(
            name = name,
            relation = relation,
            phone = PhoneNumber(phone),
            brith = birth
        )
    }

    fun toAddress(): Address {
        return Address(
            detailAddress = detailAddress,
            streetAddress = streetAddress,
            zipCode = zipCode
        )
    }
}