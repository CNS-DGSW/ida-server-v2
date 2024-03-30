package com.dgswiphak.ida.domain.applicant.domain.value.education

import com.dgswiphak.ida.domain.applicant.domain.value.education.value.type.GraduationType
import com.dgswiphak.ida.domain.applicant.domain.value.education.value.Teacher
import com.dgswiphak.ida.domain.school.model.School

data class Education(
    var school: School? = null,
    var teacher: Teacher? = null,
    var graduationType: GraduationType? = null,
    var graduateYear: Short? = -1
) {
    fun updateSchool(school: School) {
        this.school = school
    }

    fun updateTeacher(teacher: Teacher) {
        this.teacher = teacher
    }
}
