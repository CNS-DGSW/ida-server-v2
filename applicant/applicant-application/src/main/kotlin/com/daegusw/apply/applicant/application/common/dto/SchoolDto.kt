package com.daegusw.apply.applicant.application.common.dto

import com.daegusw.apply.applicant.domain.school.School
import com.daegusw.apply.applicant.domain.school.value.Teacher

data class SchoolDto(
    val graduateYear: Short,
    val schoolName: String,
    val state: String,
    val city: String,
    val code: String,
    val contact: String,
    val teacherName: String,
    val teacherPhone: String
) {
    constructor(school: School?): this(
        graduateYear = school?.graduateYear ?: 2025,
        schoolName = school?.name ?: "",
        state = school?.state ?: "",
        city = school?.city ?: "",
        code = school?.code ?: "",
        contact = school?.contact ?: "",
        teacherName = school?.teacher?.name ?: "",
        teacherPhone = school?.teacher?.phone ?: ""
    )


    fun toSchool(): School {
        return School(
            graduateYear = graduateYear,
            name = schoolName,
            state = state,
            city = city,
            code = code,
            contact = contact,
            teacher = toTeacher()
        )
    }

    private fun toTeacher(): Teacher {
        return Teacher(
            name = teacherName,
            phone = teacherPhone
        )
    }
}