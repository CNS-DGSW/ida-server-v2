package com.dgswiphak.ida.domain.school.model

import com.dgswiphak.ida.domain.applicant.domain.value.SchoolCode

data class School(
    val id: Long? = null,
    val name: String,
    val state: String,
    val city: String,
    val code: SchoolCode,
    val contact: String,
)
