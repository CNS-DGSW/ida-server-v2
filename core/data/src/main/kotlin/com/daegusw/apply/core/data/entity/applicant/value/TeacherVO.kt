package com.daegusw.apply.core.data.entity.applicant.value

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class TeacherVO(
    @Column(name = "teacher_name")
    val name: String,
    @Column(name = "teacher_phone")
    val phone: String
)