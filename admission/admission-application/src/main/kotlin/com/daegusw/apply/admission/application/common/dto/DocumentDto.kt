package com.daegusw.apply.admission.application.common.dto

import com.daegusw.apply.admission.domain.admission.value.Document

data class DocumentDto(
    val introduce: String,
    val studyPlan: String
) {
    constructor(document: Document?): this(
        introduce = document?.introduce ?: "",
        studyPlan = document?.studyPlan ?: ""
    )

    fun toDocument() = Document(
        introduce = introduce,
        studyPlan = studyPlan
    )
}