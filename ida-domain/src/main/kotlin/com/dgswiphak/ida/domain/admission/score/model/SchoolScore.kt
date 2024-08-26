package com.dgswiphak.ida.domain.admission.score.model

import com.dgswiphak.ida.domain.admission.score.model.value.Point
import com.dgswiphak.ida.domain.admission.score.model.value.grade.AttendancePoint
import com.dgswiphak.ida.domain.admission.score.model.value.grade.LeaderShipPoint
import com.dgswiphak.ida.domain.admission.score.model.value.grade.SchoolGrade
import com.dgswiphak.ida.domain.admission.score.model.value.grade.VolunteerPoint

class SchoolScore(
    id: Long? = 0,
    val schoolGrades: List<SchoolGrade> = listOf(),
    val attendances: List<AttendancePoint> = listOf(),
    val volunteers: List<VolunteerPoint> = listOf(),
    val leaderShips: List<LeaderShipPoint> = listOf(),
    val participates: Point,
    val prize: Point
): Score(id)