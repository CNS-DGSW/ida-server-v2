package com.daegusw.apply.applicant.domain.applicant.education

import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType
import com.daegusw.apply.applicant.domain.school.School

data class Education(
    var graduationType: GraduationType,
    var school: School? = null
) {
    fun updateSchool(school: School) {
        this.school = school
    }
}