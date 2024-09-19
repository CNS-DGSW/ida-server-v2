package com.daegusw.apply.applicant.application.common.dto

import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType
import com.daegusw.apply.applicant.domain.applicant.education.value.Teacher
import com.daegusw.apply.applicant.domain.school.School

data class EducationDto(
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
    constructor(graduationType: GraduationType?, graduateYear: Short?, school: School?, teacher: Teacher?): this(
        graduationType = graduationType ?: GraduationType.EXPECTED,
        graduateYear = graduateYear ?: 2025,
        schoolName = school?.name ?: "",
        state = school?.state ?: "",
        city = school?.city ?: "",
        code = school?.code ?: "",
        contact = school?.contact ?: "",
        teacherName = teacher?.name ?: "",
        teacherPhone = teacher?.phone ?: ""
    )


    fun toSchool(): School {
        return School(
            name = schoolName,
            state = state,
            city = city,
            code = code,
            contact = contact
        )
    }

    fun toTeacher(): Teacher {
        return Teacher(
            name = teacherName,
            phone = teacherPhone
        )
    }
}
