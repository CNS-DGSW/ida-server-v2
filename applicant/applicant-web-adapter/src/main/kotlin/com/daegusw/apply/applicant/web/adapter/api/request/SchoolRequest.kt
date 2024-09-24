package com.daegusw.apply.applicant.web.adapter.api.request

import com.daegusw.apply.applicant.application.common.dto.SchoolDto
import javax.validation.constraints.NotEmpty

data class SchoolRequest(
    @field:NotEmpty(message = "graduateYear(졸업년도)는 필수 속성입니다.")
    val graduateYear: Short,
    @field:NotEmpty(message = "schoolName(학교이름)은 필수 속성입니다.")
    val schoolName: String,
    @field:NotEmpty(message = "state(지역명)은 필수 속성입니다.")
    val state: String,
    @field:NotEmpty(message = "city(시군구)는 필수 속성입니다.")
    val city: String,
    @field:NotEmpty(message = "code(학교코드)는 필수 속성입니다.")
    val code: String,
    @field:NotEmpty(message = "contact(학교 연락처)는 필수 속성입니다.")
    val contact: String,
    @field:NotEmpty(message = "teacherName(담임 성명)은 필수 속성입니다.")
    val teacherName: String,
    @field:NotEmpty(message = "teacherPhone(담임 연락처)는 필수 속성입니다.")
    val teacherPhone: String
) {
    fun toDto() = SchoolDto(
        graduateYear = graduateYear,
        schoolName = schoolName,
        state = state,
        city = city,
        code = code,
        contact = contact,
        teacherName = teacherName,
        teacherPhone = teacherPhone
    )
}