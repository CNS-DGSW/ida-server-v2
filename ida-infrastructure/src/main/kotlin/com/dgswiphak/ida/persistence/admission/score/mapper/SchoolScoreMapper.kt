package com.dgswiphak.ida.persistence.admission.score.mapper

import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.domain.admission.score.model.SchoolScore
import com.dgswiphak.ida.domain.admission.score.model.value.grade.AttendancePoint
import com.dgswiphak.ida.domain.admission.score.model.value.grade.LeaderShipPoint
import com.dgswiphak.ida.domain.admission.score.model.value.grade.SchoolGrade
import com.dgswiphak.ida.domain.admission.score.model.value.grade.VolunteerPoint
import com.dgswiphak.ida.persistence.admission.score.entity.SchoolScoreEntity
import com.dgswiphak.ida.persistence.admission.score.entity.value.AttendanceVO
import com.dgswiphak.ida.persistence.admission.score.entity.value.LeaderShipVO
import com.dgswiphak.ida.persistence.admission.score.entity.value.SchoolGradeVO
import com.dgswiphak.ida.persistence.admission.score.entity.value.VolunteerVO
import org.springframework.stereotype.Component

@Component
class SchoolScoreMapper: Mapper<SchoolScore, SchoolScoreEntity> {

    private val schoolGradeMapper = SchoolGradesMapper()
    private val attendancesMapper = AttendancesMapper()
    private val volunteersMapper = VolunteersMapper()
    private val leaderShipsMapper = LeaderShipsMapper()

    override fun toDomain(entity: SchoolScoreEntity?): SchoolScore? {
        return entity?.let {
            SchoolScore(
                id = it.id!!,
                schoolGrades = schoolGradeMapper.toDomain(it.schoolGrades)!!,
                attendances = attendancesMapper.toDomain(it.attendances)!!,
                volunteers = volunteersMapper.toDomain(it.volunteers)!!,
                leaderShips = leaderShipsMapper.toDomain(it.leaderShips)!!,
                participates = it.participates,
                prize = it.prize
            )
        }
    }

    override fun toEntity(domain: SchoolScore): SchoolScoreEntity {
        return SchoolScoreEntity(
            id = domain.id!!,
            schoolGrades = schoolGradeMapper.toEntity(domain.schoolGrades),
            attendances = attendancesMapper.toEntity(domain.attendances),
            volunteers = volunteersMapper.toEntity(domain.volunteers),
            leaderShips = leaderShipsMapper.toEntity(domain.leaderShips),
            participates = domain.participates,
            prize = domain.prize
        )
    }

    inner class SchoolGradesMapper : Mapper<List<SchoolGrade>, List<SchoolGradeVO>> {
        override fun toDomain(entity: List<SchoolGradeVO>?): List<SchoolGrade>? {
            return entity?.let {
                it.stream().map {
                    vo -> SchoolGrade(
                    grade = vo.grade,
                    semester = vo.semester,
                    subject = vo.subject,
                    achieveLevel = vo.achieveLevel
                )
                }.toList()
            }
        }

        override fun toEntity(domain: List<SchoolGrade>): List<SchoolGradeVO> {
            return domain.stream().map {
                SchoolGradeVO(
                    grade = it.grade,
                    semester = it.semester,
                    subject = it.subject,
                    achieveLevel = it.achieveLevel
                )
            }.toList()
        }

    }

    inner class AttendancesMapper : Mapper<List<AttendancePoint>, List<AttendanceVO>> {
        override fun toDomain(entity: List<AttendanceVO>?): List<AttendancePoint>? {
            return entity?.let {
                it.stream().map { vo ->
                    AttendancePoint(
                        grade = vo.grade,
                        semester = vo.semester,
                        absence = vo.absence,
                        tardiness = vo.tardiness,
                        earlyLeave = vo.earlyLeave,
                        skipped = vo.skipped
                    )
                }.toList()
            }
        }

        override fun toEntity(domain: List<AttendancePoint>): List<AttendanceVO> {
            return domain.stream().map {
                AttendanceVO(
                    grade = it.grade,
                    semester = it.semester,
                    absence = it.absence,
                    tardiness = it.tardiness,
                    earlyLeave = it.earlyLeave,
                    skipped = it.skipped
                )
            }.toList()
        }

    }

    inner class VolunteersMapper : Mapper<List<VolunteerPoint>, List<VolunteerVO>> {
        override fun toDomain(entity: List<VolunteerVO>?): List<VolunteerPoint>? {
            return entity?.let {
                it.stream().map { vo ->
                    VolunteerPoint(
                        grade = vo.grade,
                        hour = vo.hour
                    )
                }.toList()
            }
        }

        override fun toEntity(domain: List<VolunteerPoint>): List<VolunteerVO> {
            return domain.stream().map {
                VolunteerVO(
                    grade = it.grade,
                    hour = it.hour
                )
            }.toList()
        }

    }

    inner class LeaderShipsMapper : Mapper<List<LeaderShipPoint>, List<LeaderShipVO>> {
        override fun toDomain(entity: List<LeaderShipVO>?): List<LeaderShipPoint>? {
            return entity?.let {
                it.stream().map { vo ->
                    LeaderShipPoint(
                        grade = vo.grade,
                        semester = vo.semester,
                        isCheck = vo.isCheck
                    )
                }.toList()
            }
        }

        override fun toEntity(domain: List<LeaderShipPoint>): List<LeaderShipVO> {
            return domain.stream().map {
                LeaderShipVO(
                    grade = it.grade,
                    semester = it.semester,
                    isCheck = it.isCheck
                )
            }.toList()
        }

    }
}
