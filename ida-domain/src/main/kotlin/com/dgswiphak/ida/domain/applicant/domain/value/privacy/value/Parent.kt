package com.dgswiphak.ida.domain.applicant.domain.value.privacy.value

import com.dgswiphak.ida.common.model.PhoneNumber
import java.time.LocalDate

data class Parent(
    val name: String,
    val relation: String,
    val phone: PhoneNumber,
    val brith: LocalDate
)