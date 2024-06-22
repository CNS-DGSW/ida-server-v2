package com.dgswiphak.ida.domain.applicant.dto.request

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.common.model.SchoolCode
import com.dgswiphak.ida.domain.applicant.model.value.education.value.Teacher
import com.dgswiphak.ida.domain.applicant.model.value.education.value.type.GraduationType
import com.dgswiphak.ida.domain.school.model.School
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateApplicantEducationRequest(
    @field:NotNull(message = "graduationType is required")
    val graduationType: GraduationType,

    @NotNull(message = "graduation year is more then 0")
    val graduateYear: Short,

    @field:NotBlank(message = "schoolName is required")
    val schoolName: String,

    @field:NotBlank(message = "state is required")
    val state: String,

    @field:NotBlank(message = "city is required")
    val city: String,

    @field:NotBlank(message = "cod is required")
    val code: String,

    @field:NotBlank(message = "contact is required")
    val contact: String,

    @field:NotBlank(message = "teacherName is required")
    val teacherName: String,

    @field:NotBlank(message = "teacherPhone is required")
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
