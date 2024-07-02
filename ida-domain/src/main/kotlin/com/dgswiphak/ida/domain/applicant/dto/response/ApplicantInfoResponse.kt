package com.dgswiphak.ida.domain.applicant.dto.response

import com.dgswiphak.ida.domain.applicant.model.value.privacy.Privacy
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class ApplicantInfoResponse(
    val name: String? = "",
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val birth: LocalDate?,
    val phoneNumber: String? = "",
    val gender: String
) {
    constructor(privacy: Privacy?) : this(
        name = privacy?.name,
        birth = privacy?.birth,
        phoneNumber = privacy?.phone?.value,
        gender = privacy?.gender!!.value
    )
}