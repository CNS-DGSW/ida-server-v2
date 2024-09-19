package com.daegusw.apply.applicant.web.adapter.api.request

import com.daegusw.apply.applicant.application.common.dto.ParentDto
import java.time.LocalDate
import javax.validation.constraints.NotEmpty

data class ParentRequest(
    @field:NotEmpty(message = "name is required")
    val name: String,
    @field:NotEmpty(message = "relation is required")
    val relation: String,
    @field:NotEmpty(message = "phone is required")
    val phone: String,
    @field:NotEmpty(message = "birth is required")
    val birth: LocalDate,
    @field:NotEmpty(message = "streetAddress is required")
    val streetAddress: String,
    @field:NotEmpty(message = "detailAddress is required")
    val detailAddress: String,
    @field:NotEmpty(message = "zipCode is required")
    val zipCode: Int,
) {
    fun toParentDto() = ParentDto(
        name = name,
        relation = relation,
        phone = phone,
        birth = birth,
        streetAddress = streetAddress,
        detailAddress = detailAddress,
        zipCode = zipCode
    )
}