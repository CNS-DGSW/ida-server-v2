package com.dgswiphak.ida.domain.applicant.dto.request

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.domain.applicant.model.value.education.value.Teacher
import com.dgswiphak.ida.domain.applicant.model.value.education.value.type.GraduationType
import com.dgswiphak.ida.common.model.SchoolCode
import com.dgswiphak.ida.domain.school.model.School

data class UpdateApplicantEducationRequest(
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
    fun toSchool(): School {
        return School(
            name = schoolName,
            state = state,
            city = city,
            code = SchoolCode(code),
            contact = PhoneNumber(contact)
        )
    }

    fun toTeacher(): Teacher {
        return Teacher(
            name = teacherName,
            contact = PhoneNumber(teacherPhone)
        )
    }
}
