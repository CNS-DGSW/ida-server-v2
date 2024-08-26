package com.dgswiphak.ida.domain.admission.score.model.value.grade

import com.dgswiphak.ida.domain.admission.score.model.value.type.Grade
import com.dgswiphak.ida.domain.admission.score.model.value.type.Semester

class LeaderShipPoint(
    val grade: Grade,
    val semester: Semester,
    val isCheck: Boolean
)
