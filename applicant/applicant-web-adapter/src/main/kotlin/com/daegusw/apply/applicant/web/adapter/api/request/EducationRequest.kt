package com.daegusw.apply.applicant.web.adapter.api.request

import com.daegusw.apply.applicant.application.common.dto.EducationDto
import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType
import javax.validation.constraints.NotEmpty

data class EducationRequest(
    @field:NotEmpty(message = "graduationType is required")
    val graduationType: GraduationType,
    @field:NotEmpty(message = "graduateYear is required")
    val graduateYear: Short,
    @field:NotEmpty(message = "schoolName is required")
    val schoolName: String,
    @field:NotEmpty(message = "state is required")
    val state: String,
    @field:NotEmpty(message = "city is required")
    val city: String,
    @field:NotEmpty(message = "code is required")
    val code: String,
    @field:NotEmpty(message = "contact is required")
    val contact: String,
    @field:NotEmpty(message = "teacherName is required")
    val teacherName: String,
    @field:NotEmpty(message = "teacherPhone is required")
    val teacherPhone: String
) {
    fun toEducationDto() = EducationDto(
        graduationType = graduationType,
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