package com.daegusw.apply.admission.domain.admission.value

data class Document(
    val introduce: String,
    val studyPlan: String,
) {
    init {
        require(introduce.isNotBlank()) { "자기소개서는 공백일 수 없습니다." }
        require(studyPlan.isNotBlank()) { "학업계획서는 공백일 수 없습니다." }
    }
}