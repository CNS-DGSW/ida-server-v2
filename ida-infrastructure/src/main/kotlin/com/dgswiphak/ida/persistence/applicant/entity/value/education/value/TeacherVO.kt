package com.dgswiphak.ida.persistence.applicant.entity.value.education.value

import com.dgswiphak.ida.common.model.PhoneNumber
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class TeacherVO(
    @Column(name = "teacher_name")
    val name: String,
    @Column(name = "teacher_contact")
    val contact: PhoneNumber
)