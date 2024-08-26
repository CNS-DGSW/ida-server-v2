package com.dgswiphak.ida.persistence.admission.score.entity

import com.dgswiphak.ida.domain.admission.score.model.value.Point
import com.dgswiphak.ida.persistence.admission.score.entity.value.AttendanceVO
import com.dgswiphak.ida.persistence.admission.score.entity.value.LeaderShipVO
import com.dgswiphak.ida.persistence.admission.score.entity.value.SchoolGradeVO
import com.dgswiphak.ida.persistence.admission.score.entity.value.VolunteerVO
import com.dgswiphak.ida.persistence.score.entity.value.*
import jakarta.persistence.*

@Entity
@Table(name = "school_score")
@DiscriminatorValue("S")
class SchoolScoreEntity(
    id: Long,
    schoolGrades: List<SchoolGradeVO>,
    attendances: List<AttendanceVO>,
    volunteers: List<VolunteerVO>,
    leaderShips: List<LeaderShipVO>,
    participates: Point,
    prize: Point,
): ScoreEntity(id) {
    @OrderColumn(name = "school_idx")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "school_grade", joinColumns = [JoinColumn(name = "score_id")])
    protected val mutableSchoolGrades: MutableList<SchoolGradeVO> = schoolGrades.toMutableList()
    val schoolGrades: List<SchoolGradeVO>
        get() = mutableSchoolGrades.toList()

    @OrderColumn(name = "attendance_idx")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "attendance", joinColumns = [JoinColumn(name = "score_id")])
    protected val mutableAttendances: MutableList<AttendanceVO> = attendances.toMutableList()
    val attendances: List<AttendanceVO>
        get() = mutableAttendances.toList()

    @OrderColumn(name = "volunteer_idx")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "volunteer", joinColumns = [JoinColumn(name = "score_id")])
    protected val mutableVolunteers: MutableList<VolunteerVO> = volunteers.toMutableList()
    val volunteers: List<VolunteerVO>
        get() = mutableVolunteers.toList()


    @OrderColumn(name = "leader_ship_idx")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "leader_ship", joinColumns = [JoinColumn(name = "score_id")])
    var mutableLeaderShips: MutableList<LeaderShipVO> = leaderShips.toMutableList()
    val leaderShips: List<LeaderShipVO>
        get() = mutableLeaderShips.toList()

    var participates: Point = participates
        protected set

    var prize: Point = prize
        protected set
}
