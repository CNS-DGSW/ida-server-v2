package com.daegusw.apply.core.data.entity.secondary.value

import javax.persistence.Embeddable

@Embeddable
class InterviewVO(
    val studyScore: Double,
    val computingScore: Double
)