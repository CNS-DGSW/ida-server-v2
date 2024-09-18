package com.daegusw.apply.applicant.web.adapter.api.request

import com.daegusw.apply.applicant.application.common.dto.InformationDto
import com.daegusw.apply.applicant.domain.applicant.privacy.constant.Gender
import java.time.LocalDate
import javax.validation.constraints.NotEmpty

data class InformationRequest(
    @field:NotEmpty(message = "title is required")
    val name: String,
    @field:NotEmpty(message = "title is required")
    val gender: Gender,
    @field:NotEmpty(message = "title is required")
    val birth: LocalDate,
    @field:NotEmpty(message = "title is required")
    val phone: String
) {
    fun toInformationDto() = InformationDto(
        name = name,
        gender = gender,
        birth = birth,
        phone = phone
    )
}