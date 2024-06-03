package com.dgswiphak.ida.domain.applicant.model.value.privacy.value

import com.dgswiphak.ida.common.model.PhoneNumber
import java.time.Instant

data class Parent(
    val name: String,
    val relation: String,
    val phone: PhoneNumber,
    val brith: Instant
) {
    init {
        if (name.isBlank()) throw IllegalArgumentException("Name cannot be blank")
        if (relation.isBlank()) throw IllegalArgumentException("Relation cannot be blank")
    }
}