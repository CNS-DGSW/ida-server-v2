package com.daegusw.apply.applicant.domain.applicant.education

import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType
import com.daegusw.apply.applicant.domain.applicant.education.value.Teacher
import com.daegusw.apply.applicant.domain.school.School

data class Education(
    var school: School,
    var teacher: Teacher?,
    var graduationType: GraduationType,
    var graduateYear: Short
) {
    fun updateSchool(school: School) {
        this.school = school
    }

    fun updateTeacher(teacher: Teacher) {
        this.teacher = teacher
    }
}