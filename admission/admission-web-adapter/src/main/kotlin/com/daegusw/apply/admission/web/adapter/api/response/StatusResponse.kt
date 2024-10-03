package com.daegusw.apply.admission.web.adapter.api.response

import com.daegusw.apply.admission.application.common.dto.StatusDto

data class StatusResponse(
    val submission: Boolean,
    val mailArrival: Boolean,
    val review: Boolean,
    val submissionTime: Boolean,
    val confirmation: Boolean
) {
    constructor(dto: StatusDto): this(
        submission = dto.submission,
        mailArrival = dto.mailArrival,
        review = dto.review,
        submissionTime = dto.submission,
        confirmation = dto.confirmation
    )
}