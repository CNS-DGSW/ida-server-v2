package com.daegusw.apply.core.data.entity.applicant.value

import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType
import com.daegusw.apply.core.data.entity.school.SchoolEntity
import javax.persistence.*

@Embeddable
data class EmbeddedEducation(
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "school_id")
    val school: SchoolEntity,

    @Embedded
    val teacher: TeacherVO?,

    @Column(name = "graduation_type")
    @Enumerated(EnumType.STRING)
    val graduationType: GraduationType,

    @Column(name = "graduate_year")
    val graduateYear: Short?
)
