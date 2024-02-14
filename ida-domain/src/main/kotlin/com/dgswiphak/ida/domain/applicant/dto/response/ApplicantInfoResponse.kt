package com.dgswiphak.ida.domain.applicant.dto.response

import com.dgswiphak.ida.domain.applicant.domain.value.Privacy
import java.time.LocalDate

data class ApplicantInfoResponse(
    val name: String,
    val birth: LocalDate?,
    val telephone: String,
    val gender: String
) {
    constructor(privacy: Privacy) : this(
        name = privacy.name ?: "",
        birth = privacy.birth,
        telephone = privacy.phone?.number ?: "",
        gender = privacy.gender?.name ?: ""
    )
}