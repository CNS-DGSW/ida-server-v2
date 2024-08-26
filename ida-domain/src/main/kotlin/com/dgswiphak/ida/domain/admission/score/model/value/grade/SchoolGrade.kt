package com.dgswiphak.ida.domain.admission.score.model.value.grade

import com.dgswiphak.ida.domain.admission.score.model.value.Subject
import com.dgswiphak.ida.domain.admission.score.model.value.type.AchieveLevel
import com.dgswiphak.ida.domain.admission.score.model.value.type.Grade
import com.dgswiphak.ida.domain.admission.score.model.value.type.Semester

data class SchoolGrade(
    val grade: Grade,
    val semester: Semester,
    val subject: Subject,
    val achieveLevel: AchieveLevel
)