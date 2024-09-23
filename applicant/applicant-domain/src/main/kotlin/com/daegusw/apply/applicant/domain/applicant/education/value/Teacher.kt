package com.daegusw.apply.applicant.domain.applicant.education.value

data class Teacher(
    val name: String,
    val phone: String
) {
    init {
        if (name.isBlank()) throw IllegalArgumentException("Teacher name cannot be blank.")
    }
}
