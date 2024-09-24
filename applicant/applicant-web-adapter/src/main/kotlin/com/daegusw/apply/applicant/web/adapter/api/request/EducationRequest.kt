package com.daegusw.apply.applicant.web.adapter.api.request

import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType
import javax.validation.constraints.NotEmpty

data class EducationRequest(
    @field:NotEmpty(message = "졸업구분(graduationType)은 필수 속성입니다.")
    val graduationType: GraduationType,
)