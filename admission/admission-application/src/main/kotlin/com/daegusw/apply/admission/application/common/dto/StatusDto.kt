package com.daegusw.apply.admission.application.common.dto

import com.daegusw.apply.admission.domain.admission.value.Status

data class StatusDto(
    val submission: Boolean,
    val mailArrival: Boolean,
    val review: Boolean,
    val submissionTime: Boolean,
    val confirmation: Boolean
) {
    constructor(status: Status): this(
        submission = status.submission,
        mailArrival = status.mailArrival,
        review = status.review,
        submissionTime = status.submission,
        confirmation = status.confirmation
    )
}