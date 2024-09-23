package com.daegusw.apply.applicant.web.adapter.api.response

import com.daegusw.apply.applicant.application.common.dto.InformationDto
import com.daegusw.apply.applicant.domain.applicant.privacy.constant.Gender
import java.time.LocalDate

data class InformationResponse(
    val name: String,
    val gender: Gender,
    val birth: LocalDate,
    val phone: String
) {
    constructor(dto: InformationDto): this(
        name = dto.name,
        gender = dto.gender,
        birth = dto.birth,
        phone = dto.phone
    )
}