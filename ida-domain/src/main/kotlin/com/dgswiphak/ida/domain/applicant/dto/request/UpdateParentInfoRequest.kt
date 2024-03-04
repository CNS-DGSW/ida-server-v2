package com.dgswiphak.ida.domain.applicant.dto.request

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.Address
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.Parent
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class UpdateParentInfoRequest(
    var name: String,
    var relation: String,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    var birth: LocalDate,

    var telephone: String,

    var streetAddress: String,

    var detailAddress: String,

    var zipCode: Int
) {
    fun toParent(): Parent {
        return Parent(
            name = name,
            relation = relation,
            phone = PhoneNumber.of(telephone),
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