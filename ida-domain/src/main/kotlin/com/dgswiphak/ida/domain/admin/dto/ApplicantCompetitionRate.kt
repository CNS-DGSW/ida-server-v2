package com.dgswiphak.ida.domain.admin.dto

data class ApplicantCompetitionRate(
    val applyType: String,
    val personnel: Int = when(applyType) {
        "일반전형" -> 41
        "특별전형(사회통합)" -> 7
        "특별전형(마이스터인재)" -> 20
        "특별전형(지역우선)" -> 4
        else -> 0
    },
    var daeguMale: Int = 0,
    var daeguFemale: Int = 0,
    var otherMale: Int = 0,
    var otherFemale: Int = 0,
    var total: Int = 0,
    var rate: Double = 0.0
)