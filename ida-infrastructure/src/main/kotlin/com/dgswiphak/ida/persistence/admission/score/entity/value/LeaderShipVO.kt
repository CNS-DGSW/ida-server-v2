package com.dgswiphak.ida.persistence.admission.score.entity.value

import com.dgswiphak.ida.domain.admission.score.model.value.type.Grade
import com.dgswiphak.ida.domain.admission.score.model.value.type.Semester
import jakarta.persistence.Embeddable

@Embeddable
class LeaderShipVO(
    val grade: Grade,
    val semester: Semester,
    val isCheck: Boolean
)
