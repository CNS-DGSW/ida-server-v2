package com.dgswiphak.ida.domain.applicant.dto.request

import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.type.Gender
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

data class UpdateApplicantInfoRequest(
    val name: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val birth: Instant,
    val phoneNumber: String,
    val gender: Gender
)