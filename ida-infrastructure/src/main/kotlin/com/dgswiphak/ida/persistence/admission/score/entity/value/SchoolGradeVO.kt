package com.dgswiphak.ida.persistence.admission.score.entity.value

import com.dgswiphak.ida.domain.admission.score.model.value.Subject
import com.dgswiphak.ida.domain.admission.score.model.value.type.AchieveLevel
import com.dgswiphak.ida.domain.admission.score.model.value.type.Grade
import com.dgswiphak.ida.domain.admission.score.model.value.type.Semester
import jakarta.persistence.Embeddable

@Embeddable
data class SchoolGradeVO(
    val grade: Grade,
    val semester: Semester,
    val subject: Subject,
    val achieveLevel: AchieveLevel
) {

}
