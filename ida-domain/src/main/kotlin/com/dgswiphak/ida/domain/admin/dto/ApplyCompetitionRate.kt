package com.dgswiphak.ida.domain.admin.dto

data class ApplyCompetitionRate(
    val applyType: String,
    val personnel: Int = when(applyType) {
        "일반전형" -> 41
        "특별전형(사회통합)" -> 7
        "특별전형(마이스터인재)" -> 20
        "특별전형(지역우선)" -> 4
        else -> 0
    },
    var daeguMen: Int = 0,
    var daeguWomen: Int = 0,
    var otherMen: Int = 0,
    var otherWomen: Int = 0,
    var total: Int = 0,
    var rate: Double = 0.0
)