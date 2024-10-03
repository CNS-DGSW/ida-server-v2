package com.daegusw.apply.core.data.entity.admission.value

import java.time.LocalDateTime
import javax.persistence.Embeddable

@Embeddable
data class AdmissionStatusVO(
    //제출 여부
    val submission: Boolean,

    //우편 도착
    val mailArrival: Boolean,

    val review: Boolean,

    val submissionTime: LocalDateTime?,

    val confirmation: Boolean
)
