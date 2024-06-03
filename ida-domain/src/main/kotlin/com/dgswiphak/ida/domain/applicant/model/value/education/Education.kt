package com.dgswiphak.ida.domain.applicant.model.value.education

import com.dgswiphak.ida.domain.applicant.model.value.education.value.type.GraduationType
import com.dgswiphak.ida.domain.applicant.model.value.education.value.Teacher
import com.dgswiphak.ida.domain.school.model.School

data class Education(
    var school: School? = null,
    var teacher: Teacher? = null,
    var graduationType: GraduationType = GraduationType.GRADUATED,
    var graduateYear: Short? = null
) {
    fun updateSchool(school: School) {
        this.school = school
    }

    fun updateTeacher(teacher: Teacher) {
        this.teacher = teacher
    }
}
