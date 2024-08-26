package com.dgswiphak.ida.domain.admission.score.model.value.grade

import com.dgswiphak.ida.domain.admission.score.model.value.type.Grade
import com.dgswiphak.ida.domain.admission.score.model.value.type.Semester

data class AttendancePoint(
    val grade: Grade,

    val semester: Semester,

    val absence: Short,

    val tardiness: Short,

    val earlyLeave: Short,

    val skipped: Short
)