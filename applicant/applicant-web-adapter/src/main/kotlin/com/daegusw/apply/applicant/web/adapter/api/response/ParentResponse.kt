package com.daegusw.apply.applicant.web.adapter.api.response

import com.daegusw.apply.applicant.application.common.dto.ParentDto
import java.time.LocalDate

data class ParentResponse(
    val name: String,
    val relation: String,
    val phone: String,
    val birth: LocalDate,
    val streetAddress: String,
    val detailAddress: String,
    val zipCode: Int,
) {
    constructor(dto: ParentDto): this(
        name = dto.name,
        relation = dto.relation,
        phone = dto.phone,
        birth = dto.birth,
        streetAddress = dto.streetAddress,
        detailAddress = dto.detailAddress,
        zipCode = dto.zipCode
    )
}