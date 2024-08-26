package com.dgswiphak.ida.domain.admission.score.model.value.grade

import com.dgswiphak.ida.domain.admission.score.model.value.Subject

data class GedGrade (
    val subject: Subject,
    val score: Double
) {
    init {
        require(score >= 0 || score <= 100) {"점수는 0점 이상 100점 이하 여야합니다."}
    }
}