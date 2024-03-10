package com.dgswiphak.ida.persistence.applicant.entity.value.education.value

import com.dgswiphak.ida.common.convert.PhoneNumberConvert
import com.dgswiphak.ida.common.model.PhoneNumber
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Embeddable
import java.io.Serial
import java.io.Serializable

@Embeddable
data class TeacherVO(
    @Column(name = "teacher_name")
    val name: String,
    @Convert(converter = PhoneNumberConvert::class)
    @Column(name = "teacher_contact")
    val contact: PhoneNumber
) : Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -28371923787
    }
}
