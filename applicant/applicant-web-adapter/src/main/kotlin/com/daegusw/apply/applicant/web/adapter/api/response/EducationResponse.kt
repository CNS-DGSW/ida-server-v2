package com.daegusw.apply.applicant.web.adapter.api.response

import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType

data class EducationResponse(
    val graduationType: GraduationType,
)