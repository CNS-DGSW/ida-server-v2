package com.dgswiphak.ida.persistence.admission.score.entity.value

import com.dgswiphak.ida.domain.admission.score.model.value.Subject
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class GedGradeVO(
    @Column(nullable = false)
    val subject: Subject,

    @Column(nullable = false)
    val score: Double
)
