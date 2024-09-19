package com.daegusw.apply.applicant.jpa.adapter.common

import com.daegusw.apply.applicant.domain.applicant.education.Education
import com.daegusw.apply.applicant.domain.applicant.education.value.Teacher
import com.daegusw.apply.applicant.jpa.adapter.common.SchoolEntityMapper.toSchool
import com.daegusw.apply.applicant.jpa.adapter.common.SchoolEntityMapper.toSchoolEntity
import com.daegusw.apply.core.data.entity.applicant.value.EmbeddedEducation
import com.daegusw.apply.core.data.entity.applicant.value.TeacherVO

object EducationMapper {
    fun toEmbeddedEducation(education: Education): EmbeddedEducation {
        return EmbeddedEducation(
            school = toSchoolEntity(education.school),
            teacher = education.teacher?.let { toTeacherVO(it) },
            graduationType = education.graduationType,
            graduateYear = education.graduateYear
        )
    }

    fun toEducation(embedded: EmbeddedEducation): Education {
        return Education(
            school = toSchool(embedded.school),
            teacher = embedded.teacher?.let { toTeacher(it) },
            graduationType = embedded.graduationType,
            graduateYear = embedded.graduateYear ?: 0
        )
    }

    private fun toTeacherVO(teacher: Teacher): TeacherVO {
        return TeacherVO(
            name = teacher.name,
            phone = teacher.phone
        )
    }

    private fun toTeacher(teacherVO: TeacherVO): Teacher {
        return Teacher(
            name = teacherVO.name,
            phone = teacherVO.phone
        )
    }
}