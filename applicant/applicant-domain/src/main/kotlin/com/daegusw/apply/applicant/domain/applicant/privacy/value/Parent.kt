package com.daegusw.apply.applicant.domain.applicant.privacy.value

import java.time.Instant

data class Parent(
    val name: String,
    val relation: String,
    val phone: String,
    val brith: Instant
) {
    init {
        if (name.isBlank()) throw IllegalArgumentException("Name cannot be blank")
        if (relation.isBlank()) throw IllegalArgumentException("Relation cannot be blank")
    }
}