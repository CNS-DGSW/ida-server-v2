package com.dgswiphak.ida.persistence.admission.score.entity.value

import com.dgswiphak.ida.domain.admission.score.model.value.type.Grade
import com.dgswiphak.ida.domain.admission.score.model.value.type.Semester
import jakarta.persistence.Embeddable

@Embeddable
data class AttendanceVO(
    val grade: Grade,

    val semester: Semester,

    val absence: Short,

    val tardiness: Short,

    val earlyLeave: Short,

    val skipped: Short
) {
}
