package com.daegusw.apply.applicant.web.adapter.api.request

import com.daegusw.apply.applicant.application.common.dto.InformationDto
import com.daegusw.apply.applicant.domain.applicant.privacy.constant.Gender
import java.time.LocalDate
import javax.validation.constraints.NotEmpty

data class InformationRequest(
    @field:NotEmpty(message = "이름(name)은 필수 속성입니다.")
    val name: String,
    @field:NotEmpty(message = "성별(gender)은 필수 속성입니다.")
    val gender: Gender,
    @field:NotEmpty(message = "생년월일(birth)은 필수 속성입니다.")
    val birth: LocalDate,
    @field:NotEmpty(message = "전화번호(phone)은 필수 속성입니다.")
    val phone: String
) {
    fun toInformationDto() = InformationDto(
        name = name,
        gender = gender,
        birth = birth,
        phone = phone
    )
}