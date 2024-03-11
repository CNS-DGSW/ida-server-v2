package com.dgswiphak.ida.domain.applicant.dto.request

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.domain.applicant.domain.value.education.value.Teacher
import com.dgswiphak.ida.domain.applicant.domain.value.education.value.type.GraduationType
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.SchoolCode
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
    val teacherContact: String
) {
    fun toSchool(): School {
        return School(
            name = schoolName,
            state = state,
            city = city,
            code = SchoolCode.of(code),
            contact = PhoneNumber(contact)
        )
    }

    fun toTeacher(): Teacher {
        return Teacher(
            name = teacherName,
            contact = PhoneNumber.of(teacherContact)
        )
    }
}
