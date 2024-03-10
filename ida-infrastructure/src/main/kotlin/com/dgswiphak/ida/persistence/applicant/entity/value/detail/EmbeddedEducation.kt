package com.dgswiphak.ida.persistence.applicant.entity.value.detail

import com.dgswiphak.ida.domain.applicant.domain.value.detail.value.type.GraduationType
import com.dgswiphak.ida.persistence.applicant.entity.value.detail.value.TeacherVO
import com.dgswiphak.ida.persistence.school.entity.SchoolEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.criteria.CriteriaBuilder.Case
import java.io.Serial
import java.io.Serializable

@Embeddable
data class EmbeddedEducation(
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "school_id")
    val school: SchoolEntity?,
    @Embedded
    val teacher: TeacherVO?,
    @Column(name = "graduation_type")
    val graduationType: GraduationType?,
    @Column(name = "graduate_year")
    val graduateYear: Short?
): Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -4349377963218637774L
    }
}
