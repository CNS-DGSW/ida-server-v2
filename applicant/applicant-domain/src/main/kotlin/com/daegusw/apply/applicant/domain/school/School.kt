package com.daegusw.apply.applicant.domain.school

import com.daegusw.apply.applicant.domain.school.value.Teacher

class School(
    val id: Long? = 0,
    val teacher: Teacher,
    val name: String,
    val state: String,
    val city: String,
    val code: String,
    val graduateYear: Short,
)