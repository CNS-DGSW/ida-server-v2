package com.dgswiphak.ida.domain.applicant.dto.response

import com.dgswiphak.ida.domain.applicant.domain.value.education.value.Teacher
import com.dgswiphak.ida.domain.applicant.domain.value.education.value.type.GraduationType
import com.dgswiphak.ida.domain.school.model.School

data class ApplicantEducationResponse(
    val graduationType: String,
    val graduateYear: Short,
    val schoolName: String,
    val state: String,
    val city: String,
    val code: String,
    val contact: String,
    val teacherName: String,
    val teacherContact: String
) {
    constructor(graduationType: GraduationType?, graduateYear: Short?, school: School?, teacher: Teacher?) : this(
        graduationType = graduationType?.name ?: "",
        //2025학년도 신입생 이라고 가정
        graduateYear = graduateYear ?: 2025,
        schoolName = school?.name ?: "",
        state = school?.state ?: "",
        city = school?.city ?: "",
        code = school?.code?.code ?: "",
        contact = school?.contact?.number ?: "",
        teacherName = teacher?.name ?: "",
        teacherContact = teacher?.contact?.number ?: ""
    )
}
