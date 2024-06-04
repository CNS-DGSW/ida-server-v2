package com.dgswiphak.ida.persistence.applicant.entity.value.education

import com.dgswiphak.ida.domain.applicant.model.value.education.value.type.GraduationType
import com.dgswiphak.ida.persistence.applicant.entity.value.education.value.TeacherVO
import com.dgswiphak.ida.persistence.school.entity.SchoolEntity
import jakarta.persistence.*

@Embeddable
data class EmbeddedEducation(
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "school_id")
    val school: SchoolEntity?,

    @Embedded
    val teacher: TeacherVO?,

    @Column(name = "graduation_type")
    @Enumerated(EnumType.STRING)
    val graduationType: GraduationType,

    @Column(name = "graduate_year")
    val graduateYear: Short?
)
