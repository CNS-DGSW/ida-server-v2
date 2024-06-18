package com.dgswiphak.ida.domain.applicant.dto.response

import com.dgswiphak.ida.domain.applicant.model.value.privacy.Privacy
import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import java.time.Instant

data class ApplicantInfoResponse(
    val name: String? = "",
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val birth: Instant?,
    val phoneNumber: String? = "",
    @field:NotBlank(message = "gender is required")
    val gender: String
) {
    constructor(privacy: Privacy?) : this(
        name = privacy?.name,
        birth = privacy?.birth,
        phoneNumber = privacy?.phone?.value,
        gender = privacy?.gender!!.value
    )
}