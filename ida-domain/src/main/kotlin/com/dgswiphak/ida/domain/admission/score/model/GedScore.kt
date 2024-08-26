package com.dgswiphak.ida.domain.admission.score.model

import com.dgswiphak.ida.domain.admission.score.model.value.Point
import com.dgswiphak.ida.domain.admission.score.model.value.grade.GedGrade

class GedScore(
    id: Long? = 0,
    val gedScores: List<GedGrade>,
    val participate: Point
): Score(id)