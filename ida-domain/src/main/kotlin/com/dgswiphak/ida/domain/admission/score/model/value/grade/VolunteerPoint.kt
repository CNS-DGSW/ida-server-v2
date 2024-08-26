package com.dgswiphak.ida.domain.admission.score.model.value.grade

import com.dgswiphak.ida.domain.admission.score.model.value.type.Grade

data class VolunteerPoint(
    val grade: Grade,

    val hour: Short,
)