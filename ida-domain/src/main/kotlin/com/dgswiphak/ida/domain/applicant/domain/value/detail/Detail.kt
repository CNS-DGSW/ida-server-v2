package com.dgswiphak.ida.domain.applicant.domain.value.detail

import com.dgswiphak.ida.domain.applicant.domain.value.detail.value.GraduationType
import com.dgswiphak.ida.domain.applicant.domain.value.detail.value.Teacher

data class Detail(
    val schoolId: String,
    val teacher: Teacher,
    val graduationType: GraduationType,
    val graduateYear: Short
)
