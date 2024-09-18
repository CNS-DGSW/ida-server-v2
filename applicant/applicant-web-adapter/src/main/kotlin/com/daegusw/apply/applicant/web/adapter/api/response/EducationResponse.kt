package com.daegusw.apply.applicant.web.adapter.api.response

import com.daegusw.apply.applicant.application.common.dto.EducationDto
import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType

data class EducationResponse(
    val graduationType: GraduationType,
    val graduateYear: Short,
    val schoolName: String,
    val state: String,
    val city: String,
    val code: String,
    val contact: String,
    val teacherName: String,
    val teacherPhone: String
) {
    constructor(dto: EducationDto) : this(
        graduationType = dto.graduationType,
        graduateYear = dto.graduateYear,
        schoolName = dto.schoolName,
        state = dto.state,
        city = dto.city,
        code = dto.code,
        contact = dto.contact,
        teacherName = dto.teacherName,
        teacherPhone = dto.teacherPhone
    )
}