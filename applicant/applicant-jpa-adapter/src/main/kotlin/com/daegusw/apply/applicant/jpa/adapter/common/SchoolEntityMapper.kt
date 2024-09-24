package com.daegusw.apply.applicant.jpa.adapter.common

import com.daegusw.apply.applicant.domain.school.School
import com.daegusw.apply.applicant.domain.school.value.Teacher
import com.daegusw.apply.core.data.entity.applicant.value.TeacherVO
import com.daegusw.apply.core.data.entity.school.SchoolEntity

object SchoolEntityMapper {
    fun toSchoolEntity(school: School): SchoolEntity {
        return SchoolEntity(
            id = school.id ?: 0,
            teacher = toTeacherVO(school.teacher),
            name = school.name,
            state = school.state,
            city = school.city,
            code = school.code,
            contact = school.contact,
            graduateYear = school.graduateYear
        )
    }

    fun toSchool(schoolEntity: SchoolEntity?): School? {
        return schoolEntity?.let {
            School(
                id = schoolEntity.id,
                teacher = toTeacher(schoolEntity.teacher),
                name = schoolEntity.name,
                state = schoolEntity.state,
                city = schoolEntity.city,
                code = schoolEntity.code,
                contact = schoolEntity.contact,
                graduateYear = schoolEntity.graduateYear
            )
        }
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