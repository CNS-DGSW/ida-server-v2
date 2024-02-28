package com.dgswiphak.ida.domain.applicant.dto.response

import com.dgswiphak.ida.domain.applicant.domain.value.Address
import com.dgswiphak.ida.domain.applicant.domain.value.Parent
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class ApplicantParentInfoResponse(
    val name: String,
    val relation: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val birth: LocalDate?,
    val telephone: String,
    val streetAddress: String,
    val detailAddress: String,
    val zipCode: Int
) {
    constructor(parent: Parent?, address: Address?) : this(
        name = parent?.name ?: "",
        relation = parent?.relation ?: "",
        birth = parent?.brith,
        telephone = parent?.phone?.number ?: "",
        streetAddress = address?.streetAddress ?: "",
        detailAddress = address?.detailAddress ?: "",
        zipCode = address?.zipCode ?: -1
    )
}
