package com.dgswiphak.ida.domain.applicant.model.value.education.value

import com.dgswiphak.ida.common.model.PhoneNumber

data class Teacher(
    val name: String,
    val contact: PhoneNumber
) {
    init {
        if (name.isNotBlank()) throw IllegalArgumentException("Teacher name cannot be blank.")
    }
}
