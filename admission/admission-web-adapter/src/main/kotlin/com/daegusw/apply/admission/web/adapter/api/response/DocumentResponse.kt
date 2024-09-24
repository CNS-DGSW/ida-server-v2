package com.daegusw.apply.admission.web.adapter.api.response

import com.daegusw.apply.admission.application.common.dto.DocumentDto

data class DocumentResponse(
    val introduce: String,
    val studyPlan: String
) {
    constructor(dto: DocumentDto): this(
        introduce = dto.introduce,
        studyPlan = dto.studyPlan
    )
}