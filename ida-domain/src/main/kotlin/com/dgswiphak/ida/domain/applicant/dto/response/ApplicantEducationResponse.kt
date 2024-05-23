package com.dgswiphak.ida.domain.applicant.dto.response

import com.dgswiphak.ida.common.util.DateUtil
import com.dgswiphak.ida.domain.applicant.model.value.education.value.Teacher
import com.dgswiphak.ida.domain.applicant.model.value.education.value.type.GraduationType
import com.dgswiphak.ida.domain.school.model.School
import com.fasterxml.jackson.annotation.JsonFormat

data class ApplicantEducationResponse(
    val graduationType: String? = "",
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val graduateYear: String? = DateUtil.localDateYearNow().toString(),
    val schoolName: String? = "",
    val state: String? = "",
    val city: String? = "",
    val schoolCode: String? = "",
    val schoolContact: String = "",
    val teacherName: String? = "",
    val teacherPhone: String? = ""
) {
    constructor(graduationType: GraduationType, graduateYear: Short?, school: School?, teacher: Teacher?) : this(
        graduationType = graduationType.value,
        graduateYear = graduateYear.toString(),
        schoolName = school?.name,
        state = school?.state,
        city = school?.city,
        schoolCode = school?.code!!.value,
        schoolContact = school.contact.value,
        teacherName = teacher?.name,
        teacherPhone = teacher?.contact!!.value
    )
}
