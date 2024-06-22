package com.dgswiphak.ida.domain.applicant.dto.request

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Address
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Parent
import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.Instant

data class UpdateParentInfoRequest(
    @field:NotBlank(message = "name is required.")
    val name: String,

    @field:NotBlank(message = "relation is required.")
    val relation: String,

    @field:NotNull(message = "birth is required.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val birth: Instant,

    @field:NotBlank(message = "phone is required.")
    val phone: String,

    @field:NotBlank(message = "street address is required.")
    val streetAddress: String,

    @field:NotBlank(message = "detail address is required.")
    val detailAddress: String,

    @field:NotNull(message = "zip code is required.")
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