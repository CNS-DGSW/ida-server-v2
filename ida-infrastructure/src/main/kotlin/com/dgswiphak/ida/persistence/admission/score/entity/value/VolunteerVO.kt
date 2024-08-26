package com.dgswiphak.ida.persistence.admission.score.entity.value

import com.dgswiphak.ida.domain.admission.score.model.value.type.Grade
import jakarta.persistence.Embeddable

@Embeddable
class VolunteerVO(
    val grade: Grade,
    val hour: Short,
)
