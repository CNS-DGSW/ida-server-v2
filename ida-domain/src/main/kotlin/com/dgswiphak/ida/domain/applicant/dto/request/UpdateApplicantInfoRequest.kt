package com.dgswiphak.ida.domain.applicant.dto.request

import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.type.Gender
import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.Instant

data class UpdateApplicantInfoRequest(
    @field:NotBlank(message = "name is required")
    val name: String,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @field:NotNull(message = "birth name is required")
    val birth: Instant,

    @field:NotBlank(message = "phone number is required")
    val phoneNumber: String,

    @field:NotNull(message = "gender name is required")
    val gender: Gender
)