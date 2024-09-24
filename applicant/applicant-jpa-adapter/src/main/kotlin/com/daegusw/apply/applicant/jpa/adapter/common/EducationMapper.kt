package com.daegusw.apply.applicant.jpa.adapter.common

import com.daegusw.apply.applicant.domain.applicant.education.Education
import com.daegusw.apply.applicant.jpa.adapter.common.SchoolEntityMapper.toSchool
import com.daegusw.apply.applicant.jpa.adapter.common.SchoolEntityMapper.toSchoolEntity
import com.daegusw.apply.core.data.entity.applicant.value.EmbeddedEducation

object EducationMapper {
    fun toEmbeddedEducation(education: Education): EmbeddedEducation {
        return EmbeddedEducation(
            school = education.school?.let { toSchoolEntity(it) },
            graduationType = education.graduationType,
        )
    }

    fun toEducation(embedded: EmbeddedEducation): Education {
        return Education(
            school = toSchool(embedded.school),
            graduationType = embedded.graduationType,
        )
    }

}