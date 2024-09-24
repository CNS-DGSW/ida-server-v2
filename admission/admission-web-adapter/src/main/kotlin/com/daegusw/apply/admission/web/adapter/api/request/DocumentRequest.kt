package com.daegusw.apply.admission.web.adapter.api.request

import com.daegusw.apply.admission.application.common.dto.DocumentDto

data class DocumentRequest(
    val introduce: String,
    val studyPlan: String
) {
    fun toDocumentDto() = DocumentDto(
        introduce = introduce,
        studyPlan = studyPlan
    )
}