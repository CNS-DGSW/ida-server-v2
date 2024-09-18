package com.daegusw.apply.applicant.jpa.adapter.common

import com.daegusw.apply.applicant.domain.school.School
import com.daegusw.apply.core.data.entity.school.SchoolEntity

object SchoolEntityMapper {
    fun toSchoolEntity(school: School): SchoolEntity {
        return SchoolEntity(
            id = school.id ?: 0,
            name = school.name,
            state = school.state,
            city = school.city,
            code = school.code,
            contact = school.contact
        )
    }

    fun toSchool(schoolEntity: SchoolEntity): School {
        return School(
            id = schoolEntity.id,
            name = schoolEntity.name,
            state = schoolEntity.state,
            city = schoolEntity.city,
            code = schoolEntity.code,
            contact = schoolEntity.contact
        )
    }
}