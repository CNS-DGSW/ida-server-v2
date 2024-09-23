package com.daegusw.apply.applicant.domain.applicant.privacy.value

import java.time.LocalDate

data class Parent(
    val name: String,
    val relation: String,
    val phone: String,
    val birth: LocalDate
) {
    init {
        if (name.isBlank()) throw IllegalArgumentException("Name cannot be blank")
        if (relation.isBlank()) throw IllegalArgumentException("Relation cannot be blank")
    }
}