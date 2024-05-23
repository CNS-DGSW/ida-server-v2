package com.dgswiphak.ida.domain.applicant.dto.response

import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Address
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Parent
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

data class ApplicantParentInfoResponse(
    val name: String?,
    val relation: String?,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val birth: Instant?,
    val telephone: String?,
    val streetAddress: String?,
    val detailAddress: String?,
    val zipCode: Int?
) {
    constructor(parent: Parent?, address: Address?) : this(
        name = parent?.name,
        relation = parent?.relation,
        birth = parent?.brith,
        telephone = parent?.phone?.value,
        streetAddress = address?.streetAddress,
        detailAddress = address?.detailAddress,
        zipCode = address?.zipCode
    )
}
